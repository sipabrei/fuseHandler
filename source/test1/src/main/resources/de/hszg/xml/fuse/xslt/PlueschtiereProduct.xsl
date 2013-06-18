<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns1="http://xml.netbeans.org/schema/response_search"
	xmlns="http://www.example.org/MainProductSchema">
	<xsl:import href="src/main/resources/de/hszg/xml/fuse/xslt/MainProduct.xsl" />
	<xsl:template match="ns1:attributes">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="ns1:attribute">
		<xsl:variable name="attributetype">
			<xsl:value-of select="ns1:attributetype" />
		</xsl:variable>

		<xsl:choose>
			<xsl:when test="$attributetype = 'Farbe Plueschtiere'">
				<color>
					<xsl:value-of select="ns1:attributecontent" />
				</color>
			</xsl:when>
		</xsl:choose>

		<xsl:choose>
			<xsl:when test="$attributetype = 'Geschlecht'">
				<gender>
					<xsl:value-of select="ns1:attributecontent" />
				</gender>
			</xsl:when>
		</xsl:choose>

		<xsl:choose>
			<xsl:when test="$attributetype = 'Groeße Stoff'">
				<size>
					<xsl:value-of select="ns1:attributecontent" />
				</size>
			</xsl:when>
		</xsl:choose>

		<xsl:choose>
			<xsl:when test="$attributetype = 'Tierart'">
				<species>
					<xsl:value-of select="ns1:attributecontent" />
				</species>
			</xsl:when>
		</xsl:choose>

		<xsl:choose>
			<xsl:when test="$attributetype = 'Zielgruppe'">
				<target-group>
					<xsl:value-of select="ns1:attributecontent" />
				</target-group>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet> 