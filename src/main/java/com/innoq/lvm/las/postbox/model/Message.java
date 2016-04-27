package com.innoq.lvm.las.postbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mjansing on 09/03/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
	@JsonProperty("userId") // explicit json mapping
	private String userId;

	@JsonProperty("entryId") // explicit json mapping
	private int entryId;

	@JsonProperty("datum")
	private String date;

	@JsonProperty("text") // explicit json mapping
	private String text;

	@JsonProperty("bezug")
	private String reference;

	@JsonProperty("bezugId")
	private int referenceId;

	@JsonProperty("bezugURI")
	private String referenceUri;

	@JsonProperty("partnerId")
	private int partnerId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public String getReferenceUri() {
		return referenceUri;
	}

	public void setReferenceUri(String referenceUri) {
		this.referenceUri = referenceUri;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	@Override
	public String toString() {
		return "Message{" +
			"userId='" + userId + '\'' +
			", entryId=" + entryId +
			", date='" + date + '\'' +
			", text='" + text + '\'' +
			", reference='" + reference + '\'' +
			", referenceId=" + referenceId +
			", referenceUri='" + referenceUri + '\'' +
			", partnerId=" + partnerId +
			'}';
	}
}
