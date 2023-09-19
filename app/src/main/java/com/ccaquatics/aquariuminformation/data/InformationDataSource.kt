package com.ccaquatics.aquariuminformation.data

import com.ccaquatics.aquariuminformation.R

val informationHeaderData =
	TextData(text = R.string.text_info_1)

val informationData =
	TextData(R.string.text_info_2)

val errorData =
	HeaderData(
		icon = R.drawable.ic_bug_report,
		title = R.string.errors_or_bugs,
		text = R.string.text_app_errors,
	)

val contactData =
	HeaderData(
		icon = R.drawable.ic_person_search,
		title = R.string.contact,
		text = R.string.text_title_info,
	)

val emailData =
	HeaderData(
		icon = R.drawable.ic_mail,
		title = R.string.text_email,
		text = R.string.text_title_info,
	)

val websiteData =
	HeaderData(
		icon = R.drawable.ic_public,
		title = R.string.text_website,
		text = R.string.text_title_info,
	)

val appInformationData =
	HeaderData(
		icon = R.drawable.ic_settings_alert,
		title = R.string.app_name,
		text = R.string.app_name,
	)

val appVersionData =
	HeaderData(
		icon = R.drawable.ic_settings_alert,
		title = R.string.app_version,
		text = R.string.appVersion,
	)