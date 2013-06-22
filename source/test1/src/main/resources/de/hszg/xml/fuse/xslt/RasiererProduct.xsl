<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns1="http://xml.netbeans.org/schema/response_search"
	 xmlns="http://www.example.org/Rasierer">
	<xsl:import href="MainProduct.xsl" />
	<xsl:template match="ns1:attributes">
		<information><xsl:for-each select="ns1:attribute"><xsl:value-of select="ns1:attributecontent" />,</xsl:for-each></information>
		<xsl:apply-templates />
	</xsl:template>
</xsl:stylesheet> 