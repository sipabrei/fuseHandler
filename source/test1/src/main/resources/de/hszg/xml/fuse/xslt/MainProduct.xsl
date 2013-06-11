<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="text" />
	<xsl:template match="/">
		<product xmlns="http://www.example.org/MainProductSchema">
			<xsl:apply-templates />
		</product>
	</xsl:template>

	<xsl:template match="articel">
		<name>
			<xsl:value-of select="@Name" />
		</name>
		<xsl:apply-templates /> 
	</xsl:template>

	<xsl:template match="price">
		<price>
			<xsl:value-of select="." />
		</price>
		
	</xsl:template>
	<xsl:template match="text">
		<description>
			<xsl:value-of select="." />
		</description>
	</xsl:template>
	<xsl:template match="@category">
	</xsl:template>
 <xsl:template match="node()">
	</xsl:template>
</xsl:stylesheet> 