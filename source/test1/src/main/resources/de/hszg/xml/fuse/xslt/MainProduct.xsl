<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns1="http://xml.netbeans.org/schema/response_search"
	xmlns="http://www.example.org/MainProductSchema">
	<xsl:template match="/">
		<product>
			<xsl:apply-templates />
		</product>
	</xsl:template>
	<xsl:template match="ns1:root">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="ns1:result">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="ns1:maingroup">
		<group>
			<xsl:attribute name="sub">
			<xsl:value-of select="ns1:subgroup/@name" />
		</xsl:attribute>
			<xsl:value-of select="@name" />
		</group>
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="ns1:subgroup">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="ns1:product">
		<name>
			<xsl:value-of select="@id" />
		</name>
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="ns1:price">
		<price>
			<xsl:value-of select="." />
		</price>
	</xsl:template>
	<xsl:template match="ns1:pic">
		<image>
			<xsl:value-of select="." />
		</image>
	</xsl:template>
	<xsl:template match="ns1:description">
		<description>
			<xsl:value-of select="." />
		</description>
	</xsl:template>
	<xsl:template match="node()">
	</xsl:template>
</xsl:stylesheet> 