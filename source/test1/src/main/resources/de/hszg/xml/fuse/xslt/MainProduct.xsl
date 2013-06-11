<xsl:stylesheet version='1.0'
	xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>
	<xsl:template match="/">
		<product xmlns="http://www.example.org/MainProductSchema">
			<xsl:apply-templates select="@name" />
			<xsl:apply-templates select="@category" />
			<xsl:apply-templates select="/article/price" />
			<xsl:apply-templates select="/article/text" />


		</product>
	</xsl:template>

	<xsl:template match="/article/price">
		<price>
			<xsl:value-of select="." />
		</price>
	</xsl:template>
	<xsl:template match="/article/text">
		<description>
			<xsl:value-of select="." />
		</description>
	</xsl:template>


	<xsl:template match="@name">
		<name>
			<xsl:value-of select="." />
		</name>
	</xsl:template>
	<xsl:template match="@category">
	</xsl:template>
</xsl:stylesheet> 