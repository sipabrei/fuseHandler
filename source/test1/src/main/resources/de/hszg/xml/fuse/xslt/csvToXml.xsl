<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  xmlns:fn="http://www.w3.org/2005/xpath-functions" 
  xmlns:xcsvt="http://www.seanbdurkin.id.au/xslt/csv-to-xml.xslt" 
  xmlns:xs="http://www.w3.org/2001/XMLSchema" 
  xmlns:xcsv="http://www.seanbdurkin.id.au/xslt/xcsv.xsd"
  version="2.0"
  exclude-result-prefixes="xsl xs fn xcsvt xcsv">
<xsl:import href="csv-to-xml.xslt" />
<xsl:output indent="yes" encoding="UTF-8" method="xml"/>
<xsl:import-schema schema-location="http://www.seanbdurkin.id.au/xslt/xcsv.xsd"
                   use-when="system-property('xsl:is-schema-aware')='yes'" />
<xsl:param name="testData/handler2/searchRespone1.csv" as="xs:string" />

<xsl:import-schema schema-location="http://www.seanbdurkin.id.au/xslt/xcsv.xsd"
                   use-when="system-property('xsl:is-schema-aware')='yes'" />


<xsl:template match="/">
  <xsl:variable name="phase-1-result">
    <xsl:call-template name="xcsvt:main" /><!-- phase 1 -->
  </xsl:variable>
  <xsl:apply-templates select="$phase-1-result" mode="phase-2"/>
 <people>
   <xsl:apply-templates select="
     $phase-1-result/
	 xcsv:comma-separated-single-line-values/
	 (xcsv:row[position() ge 2])" mode="phase-2"/>
 </people>
</xsl:template>

<xsl:template match="@*|</strong>" mode="phase-2" />

<xsl:template match="xcsv:row" mode="phase-2">
 <product>
 <productid> <xsl:value-of select="xcsv:value[1]" /></product-id>
  <productName> <xsl:value-of select="xcsv:value[2]" /></productName>
  <amount> <xsl:value-of select="xcsv:value[3]" /></amount>
  <description> <xsl:value-of select="xcsv:value[3]" /></description>
 </product>
</xsl:template>

</xsl:stylesheet>