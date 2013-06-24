<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns1="http://xml.netbeans.org/schema/response_search"
	xmlns="http://www.example.org/MainProductSchema.xsd">
	<xsl:template match="/">
		<root>
			<xsl:apply-templates />
		</root>
	</xsl:template>
	<xsl:template match="CsvHandler">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="product">
		<product>
		<xsl:apply-templates />
		</product>
	</xsl:template>
	<xsl:template match="ProductGroup">
		<group>
			<xsl:attribute name="sub"/>
			<xsl:value-of select="." />
		</group>
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="Product">
		<name>
			<xsl:value-of select="." />
		</name>
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="Details">
		<description>
			<xsl:value-of select="." />
		</description>
	</xsl:template>
	<xsl:template match="node()">
	</xsl:template>
</xsl:stylesheet> 