package com.kotlinmvvm.model

import java.io.Serializable

/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */

data class Museum(
    val id: Int, val name: String, val image: String,
    val artist: String? = null,
    val date: String? = null,
    val description: String? = null,
    val department: String? = null,
    val medium: String? = null,
) : Serializable

data class ClevelandResponse(
    val info: ClevelandInfo? = null,
    val data: List<ClevelandArtwork>? = null
) : Serializable

data class ClevelandInfo(
    val total: Int? = null,
    val parameters: ClevelandParameters? = null
)

data class ClevelandParameters(
    val skip: Int? = null,
    val limit: Int? = null,
    val select: String? = null
)


data class ClevelandArtwork(
    val id: Int? = null,
    val accessionNumber: String? = null,
    val shareLicenseStatus: String? = null,
    val tombstone: String? = null,
    val currentLocation: String? = null,
    val title: String? = null,
    val creationDate: String? = null,
    val creationDateEarliest: Int? = null,
    val creationDateLatest: Int? = null,
    val artistsTags: List<String>? = null,
    val culture: List<String>? = null,
    val technique: String? = null,
    val supportMaterials: List<String>? = null,
    val department: String? = null,
    val collection: String? = null,
    val type: String? = null,
    val measurements: String? = null,
    val dimensions: Dimensions? = null,
    val stateOfTheWork: String? = null,
    val editionOfTheWork: String? = null,
    val copyright: String? = null,
    val inscriptions: List<ClevelandInscription>? = null,
    val exhibitions: Exhibitions? = null,
    val provenance: List<Provenance>? = null,
    val findSpot: String? = null,
    val relatedWorks: List<String>? = null,
    val formerAccessionNumbers: List<String>? = null,
    val didYouKnow: String? = null,
    val description: String? = null,
    val externalResources: ExternalResources? = null,
    val citations: List<Citation>? = null,
    val url: String? = null,
    val images: Images? = null,
    val alternateImages: List<AlternateImage>? = null,
    val creditline: String? = null,
    val sketchfabId: String? = null,
    val sketchfabUrl: String? = null,
    val galleryDonorText: String? = null,
    val athenaId: Int? = null,
    val creators: List<Creator>? = null,
    val legalStatus: String? = null,
    val accessionDate: String? = null,
    val sortableDate: Int? = null,
    val dateText: String? = null,
    val collapseArtists: Boolean? = null,
    val onLoan: Boolean? = null,
    val recentlyAcquired: Boolean? = null,
    val recordType: String? = null,
    val conservationStatement: String? = null,
    val hasConservationImages: Boolean? = null,
    val coverAccessionNumber: String? = null,
    val isNaziEraProvenance: Boolean? = null,
    val impression: String? = null,
    val alternateTitles: List<String>? = null,
    val isHighlight: Boolean? = null,
    val updatedAt: String? = null
)

data class ClevelandInscription(
    val inscription: String? = null,
    val inscription_translation: String? = null,
    val inscription_remark: String? = null,
    val sortorder: Int? = null
)
data class Dimensions(
    val framed: FramedDimensions? = null,
    val unframed: UnframedDimensions? = null
)

data class FramedDimensions(
    val height: Double? = null,
    val width: Double? = null,
    val depth: Double? = null
)

data class UnframedDimensions(
    val height: Double? = null,
    val width: Double? = null
)

data class Exhibitions(
    val current: List<Exhibition>? = null,
    val legacy: List<LegacyExhibition>? = null
)

data class Exhibition(
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val openingDate: String? = null
)

data class LegacyExhibition(
    val description: String? = null,
    val openingDate: String? = null
)

data class Provenance(
    val description: String? = null,
    val citations: List<String>? = null,
    val footnotes: List<String>? = null,
    val date: String? = null,
    val sortorder: Int? = null
)

data class ExternalResources(
    val wikidata: List<String>? = null,
    val internetArchive: List<String>? = null
)

data class Citation(
    val citation: String? = null,
    val pageNumber: String? = null,
    val url: String? = null
)

data class Images(
    val annotation: String? = null,
    val web: ImageDetail? = null,
    val print: ImageDetail? = null,
    val full: ImageDetail? = null
)

data class ImageDetail(
    val url: String? = null,
    val width: String? = null,
    val height: String? = null,
    val filesize: String? = null,
    val filename: String? = null
)

data class AlternateImage(
    val dateCreated: String? = null,
    val annotation: String? = null,
    val web: ImageDetail? = null,
    val print: ImageDetail? = null,
    val full: ImageDetail? = null
)

data class Creator(
    val id: Int? = null,
    val description: String? = null,
    val extent: String? = null,
    val qualifier: String? = null,
    val role: String? = null,
    val biography: String? = null,
    val nameInOriginalLanguage: String? = null,
    val birthYear: String? = null,
    val deathYear: String? = null
)

// Main Artwork Model
//data class ClevelandArtwork(
//    val id: Int? = null,
//    val title: String? = null,
//    val images: ClevelandImages? = null,
//    val creators: List<ClevelandCreator>? = null,
//    val creation_date: String? = null,
//    val creation_date_earliest: Int? = null,
//    val creation_date_latest: Int? = null,
//    val technique: String? = null,
//    val medium: String? = null,
//    val dimensions: String? = null,
//    val department: String? = null,
//    val collection: String? = null,
//    val type: String? = null,
//    val culture: List<String>? = null,
//    val style: List<String>? = null,
//    val inscriptions: List<String>? = null,
//    val exhibitions: ClevelandExhibitions? = null,
//    val provenance: List<String>? = null,
//    val find_spot: String? = null,
//    val related_works: List<String>? = null,
//    val former_accession_numbers: List<String>? = null,
//    val fun_fact: String? = null,
//    val digital_description: String? = null,
//    val wall_description: String? = null,
//    val external_resources: ClevelandExternalResources? = null
//) {
//    val name: String get() = title ?: "Untitled"
//    val image: String get() = images?.web?.url ?: ""
//    val artist: String get() = creators?.firstOrNull()?.description ?: "Unknown Artist"
//    val date: String get() = creation_date ?: "Unknown Date"
//    val smallImage: String get() = images?.print?.url ?: image
//}
//
//// Image Models
//data class ClevelandImages(
//    val web: ClevelandImageData? = null,
//    val print: ClevelandImageData? = null,
//    val full: ClevelandImageData? = null
//)
//
//data class ClevelandImageData(
//    val url: String? = null,
//    val width: Int? = null,
//    val height: Int? = null,
//    val filesize: Int? = null
//)
//
//// Creator Model
//data class ClevelandCreator(
//    val description: String? = null,
//    val extent: String? = null,
//    val qualifier: String? = null,
//    val role: String? = null,
//    val birthyear: String? = null,
//    val deathyear: String? = null,
//    val nationality: String? = null,
//    val biography: String? = null
//)
//
//// Additional Models
//data class ClevelandExhibitions(
//    val current: List<ClevelandExhibition>? = null,
//    val legacy: List<String>? = null
//)
//
//data class ClevelandExhibition(
//    val id: Int? = null,
//    val title: String? = null,
//    val description: String? = null,
//    val opening_date: String? = null
//)
//
//data class ClevelandExternalResources(
//    val wikidata: List<String>? = null,
//    val internet_archive: List<String>? = null,
//    val isni: List<String>? = null,
//    val viaf: List<String>? = null
//)