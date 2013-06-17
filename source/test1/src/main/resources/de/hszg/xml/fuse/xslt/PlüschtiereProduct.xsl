<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns1="http://xml.netbeans.org/schema/response_search"
	xmlns="http://www.example.org/MainProductSchema">
	<xsl:import href="MainProduct.xsl" />
	<xsl:template match="ns1:attributes">
	
	<xsl:variable name="attributetype" select="ns1:attributetype"/>
	 <xsl:choose>
	  <xsl:when test="@attributetype = 'Farbe Plüschtiere'">
	  <color><xsl:value-of select="/ns1:attributecontent" /> </color>
	  </xsl:when>
	 
	 </xsl:choose>
	
	</xsl:template>
</xsl:stylesheet> 