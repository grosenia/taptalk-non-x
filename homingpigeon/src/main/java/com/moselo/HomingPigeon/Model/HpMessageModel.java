package com.moselo.HomingPigeon.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.moselo.HomingPigeon.Helper.HpUtils;
import com.moselo.HomingPigeon.Manager.HpEncryptorManager;

import java.security.GeneralSecurityException;

/**
 * If this class has more attribute, don't forget to add it to copyMessageModel function
 */
public class HpMessageModel implements Parcelable {
    @Nullable @JsonProperty("messageID") @JsonAlias("id") private String messageID;
    @NonNull @JsonProperty("localID") private String localID;
    @JsonProperty("room") private HpRoomModel room;
    @JsonProperty("type") private int type;
    @JsonProperty("body") private String body;
    @JsonProperty("created") private Long created;
    @JsonProperty("user") private HpUserModel user;
    @JsonProperty("recipientID") private String recipientID;
    @Nullable @JsonProperty("isRead") private Boolean isRead;
    @Nullable @JsonProperty("isDelivered") private Boolean isDelivered;
    @Nullable @JsonProperty("isHidden") private Boolean isHidden;
    @Nullable @JsonProperty("isDeleted") private Boolean isDeleted;
    @Nullable @JsonProperty("isSending") private Boolean isSending;
    @Nullable @JsonProperty("isFailedSend") private Boolean isFailedSend;
    @Nullable @JsonProperty("updated") private Long updated;
    @JsonIgnore private HpMessageModel replyTo; // TODO: 1 November 2018 TESTING REPLY LAYOUT
    @JsonIgnore private boolean isExpanded, isFirstLoadFinished, isNeedAnimateSend;
    @JsonIgnore private int imageWidth, imageHeight;

    public HpMessageModel(@Nullable String messageID, @NonNull String localID, String body, HpRoomModel room,
                          Integer type, Long created, HpUserModel user, String recipientID, @Nullable Boolean isDeleted,
                          @Nullable Boolean isSending, @Nullable Boolean isFailedSend, @Nullable Long updated) {
        this.messageID = messageID;
        this.localID = localID;
        this.body = body;
        this.room = room;
        this.type = type;
        this.created = created;
        this.user = user;
        this.recipientID = recipientID;
        this.isDeleted = isDeleted;
        this.isSending = isSending;
        this.isFailedSend = isFailedSend;
        this.updated = updated;
        // Update when adding fields to model
    }

    public HpMessageModel() {
    }

    public static HpMessageModel Builder(String message, HpRoomModel room, Integer type, Long created, HpUserModel user, String recipientID) {
        String localID = HpUtils.getInstance().generateRandomString(32);
        return new HpMessageModel("0", localID, message, room, type, created, user, recipientID, false, true, false, created);
    }

    public static HpMessageModel BuilderEncrypt(HpMessageModel messageModel) throws GeneralSecurityException {
        return new HpMessageModel(
                messageModel.getMessageID(),
                messageModel.getLocalID(),
                HpEncryptorManager.getInstance().encrypt(messageModel.getBody(), messageModel.getLocalID()),
                messageModel.getRoom(),
                messageModel.getType(),
                messageModel.getCreated(),
                messageModel.getUser(),
                messageModel.getRecipientID(),
                messageModel.getDeleted(),
                messageModel.getSending(),
                messageModel.getFailedSend(),
                messageModel.getUpdated());
    }

    public static HpMessageModel BuilderDecrypt(HpMessageModel messageModel) throws GeneralSecurityException {
        return new HpMessageModel(
                messageModel.getMessageID(),
                messageModel.getLocalID(),
                HpEncryptorManager.getInstance().decrypt(messageModel.getBody(), messageModel.getLocalID()),
                messageModel.getRoom(),
                messageModel.getType(),
                messageModel.getCreated(),
                messageModel.getUser(),
                messageModel.getRecipientID(),
                messageModel.getDeleted(),
                messageModel.getSending(),
                messageModel.getFailedSend(),
                messageModel.getUpdated());
    }

    @Nullable
    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(@Nullable String messageID) {
        this.messageID = messageID;
    }

    @NonNull
    public String getLocalID() {
        return localID;
    }

    public void setLocalID(@NonNull String localID) {
        this.localID = localID;
    }

    public HpRoomModel getRoom() {
        return room;
    }

    public void setRoom(HpRoomModel room) {
        this.room = room;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public HpUserModel getUser() {
        return user;
    }

    public void setUser(HpUserModel user) {
        this.user = user;
    }

    public String getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(String recipientID) {
        this.recipientID = recipientID;
    }

    @Nullable
    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(@Nullable Boolean read) {
        isRead = read;
    }

    @Nullable
    public Boolean getDelivered() {
        return isDelivered;
    }

    public void setDelivered(@Nullable Boolean delivered) {
        isDelivered = delivered;
    }

    @Nullable
    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(@Nullable Boolean hidden) {
        isHidden = hidden;
    }

    @Nullable
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(@Nullable Boolean deleted) {
        isDeleted = deleted;
    }

    @Nullable
    public Boolean getSending() {
        return isSending;
    }

    public void setSending(@Nullable Boolean sending) {
        isSending = sending;
    }

    @Nullable
    public Boolean getFailedSend() {
        return isFailedSend;
    }

    public void setFailedSend(@Nullable Boolean failedSend) {
        isFailedSend = failedSend;
    }

    @Nullable
    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(@Nullable Long updated) {
        this.updated = updated;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public boolean isFirstLoadFinished() {
        return isFirstLoadFinished;
    }

    public void setFirstLoadFinished(boolean firstLoadFinished) {
        isFirstLoadFinished = firstLoadFinished;
    }

    public boolean isNeedAnimateSend() {
        return isNeedAnimateSend;
    }

    public void setNeedAnimateSend(boolean sendAnimateFinished) {
        isNeedAnimateSend = sendAnimateFinished;
    }

    public HpMessageModel getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(HpMessageModel replyTo) {
        this.replyTo = replyTo;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public void updateValue(HpMessageModel model) {
        this.messageID = model.getMessageID();
        this.localID = model.getLocalID();
        this.body = model.getBody();
        this.room = model.getRoom();
        this.type = model.getType();
        this.created = model.getCreated();
        this.user = model.getUser();
        this.isDeleted = model.getDeleted();
        this.isSending = model.getSending();
        this.isFailedSend = model.getFailedSend();
        this.updated = model.getUpdated();
        // Update when adding fields to model
    }

    public HpMessageModel copyMessageModel() {
        return new HpMessageModel(
                getMessageID(),
                getLocalID(),
                getBody(),
                getRoom(),
                getType(),
                getCreated(),
                getUser(),
                getRecipientID(),
                getDeleted(),
                getSending(),
                getFailedSend(),
                getUpdated());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.messageID);
        dest.writeString(this.localID);
        dest.writeParcelable(this.room, flags);
        dest.writeInt(this.type);
        dest.writeString(this.body);
        dest.writeValue(this.created);
        dest.writeParcelable(this.user, flags);
        dest.writeString(this.recipientID);
        dest.writeValue(this.isRead);
        dest.writeValue(this.isDelivered);
        dest.writeValue(this.isHidden);
        dest.writeValue(this.isDeleted);
        dest.writeValue(this.isSending);
        dest.writeValue(this.isFailedSend);
        dest.writeValue(this.updated);
        dest.writeParcelable(this.replyTo, flags);
        dest.writeByte(this.isExpanded ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isFirstLoadFinished ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isNeedAnimateSend ? (byte) 1 : (byte) 0);
        dest.writeInt(this.imageWidth);
        dest.writeInt(this.imageHeight);
    }

    protected HpMessageModel(Parcel in) {
        this.messageID = in.readString();
        this.localID = in.readString();
        this.room = in.readParcelable(HpRoomModel.class.getClassLoader());
        this.type = in.readInt();
        this.body = in.readString();
        this.created = (Long) in.readValue(Long.class.getClassLoader());
        this.user = in.readParcelable(HpUserModel.class.getClassLoader());
        this.recipientID = in.readString();
        this.isRead = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.isDelivered = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.isHidden = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.isDeleted = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.isSending = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.isFailedSend = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.updated = (Long) in.readValue(Long.class.getClassLoader());
        this.replyTo = in.readParcelable(HpMessageModel.class.getClassLoader());
        this.isExpanded = in.readByte() != 0;
        this.isFirstLoadFinished = in.readByte() != 0;
        this.isNeedAnimateSend = in.readByte() != 0;
        this.imageWidth = in.readInt();
        this.imageHeight = in.readInt();
    }

    public static final Parcelable.Creator<HpMessageModel> CREATOR = new Parcelable.Creator<HpMessageModel>() {
        @Override
        public HpMessageModel createFromParcel(Parcel source) {
            return new HpMessageModel(source);
        }

        @Override
        public HpMessageModel[] newArray(int size) {
            return new HpMessageModel[size];
        }
    };
}
