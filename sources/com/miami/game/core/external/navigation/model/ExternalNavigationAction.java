package com.miami.game.core.external.navigation.model;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ExternalNavigationAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "", "OpenUri", "SendText", "ShareImageWithDescription", "OpenDeepLink", "DialPhoneNumber", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$DialPhoneNumber;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$OpenDeepLink;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$OpenUri;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$SendText;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$ShareImageWithDescription;", "external-navigation_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ExternalNavigationAction {

    /* compiled from: ExternalNavigationAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$OpenUri;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "external-navigation_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OpenUri implements ExternalNavigationAction {
        public static final int $stable = 8;
        private final Uri uri;

        public static /* synthetic */ OpenUri copy$default(OpenUri openUri, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = openUri.uri;
            }
            return openUri.copy(uri);
        }

        public final Uri component1() {
            return this.uri;
        }

        public final OpenUri copy(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new OpenUri(uri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenUri) && Intrinsics.areEqual(this.uri, ((OpenUri) obj).uri);
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "OpenUri(uri=" + this.uri + ")";
        }

        public OpenUri(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
        }

        public final Uri getUri() {
            return this.uri;
        }
    }

    /* compiled from: ExternalNavigationAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$SendText;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "external-navigation_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class SendText implements ExternalNavigationAction {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ SendText copy$default(SendText sendText, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sendText.text;
            }
            return sendText.copy(str);
        }

        public final String component1() {
            return this.text;
        }

        public final SendText copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new SendText(text);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SendText) && Intrinsics.areEqual(this.text, ((SendText) obj).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "SendText(text=" + this.text + ")";
        }

        public SendText(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: ExternalNavigationAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$ShareImageWithDescription;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "fileUri", "Landroid/net/Uri;", "description", "", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "getFileUri", "()Landroid/net/Uri;", "getDescription", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "external-navigation_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ShareImageWithDescription implements ExternalNavigationAction {
        public static final int $stable = 8;
        private final String description;
        private final Uri fileUri;

        public static /* synthetic */ ShareImageWithDescription copy$default(ShareImageWithDescription shareImageWithDescription, Uri uri, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = shareImageWithDescription.fileUri;
            }
            if ((i & 2) != 0) {
                str = shareImageWithDescription.description;
            }
            return shareImageWithDescription.copy(uri, str);
        }

        public final Uri component1() {
            return this.fileUri;
        }

        public final String component2() {
            return this.description;
        }

        public final ShareImageWithDescription copy(Uri fileUri, String description) {
            Intrinsics.checkNotNullParameter(fileUri, "fileUri");
            Intrinsics.checkNotNullParameter(description, "description");
            return new ShareImageWithDescription(fileUri, description);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShareImageWithDescription) {
                ShareImageWithDescription shareImageWithDescription = (ShareImageWithDescription) obj;
                return Intrinsics.areEqual(this.fileUri, shareImageWithDescription.fileUri) && Intrinsics.areEqual(this.description, shareImageWithDescription.description);
            }
            return false;
        }

        public int hashCode() {
            return (this.fileUri.hashCode() * 31) + this.description.hashCode();
        }

        public String toString() {
            Uri uri = this.fileUri;
            return "ShareImageWithDescription(fileUri=" + uri + ", description=" + this.description + ")";
        }

        public ShareImageWithDescription(Uri fileUri, String description) {
            Intrinsics.checkNotNullParameter(fileUri, "fileUri");
            Intrinsics.checkNotNullParameter(description, "description");
            this.fileUri = fileUri;
            this.description = description;
        }

        public final Uri getFileUri() {
            return this.fileUri;
        }

        public final String getDescription() {
            return this.description;
        }
    }

    /* compiled from: ExternalNavigationAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$OpenDeepLink;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "deeplinkUri", "Landroid/net/Uri;", "defaultPackageName", "", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "getDeeplinkUri", "()Landroid/net/Uri;", "getDefaultPackageName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "external-navigation_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OpenDeepLink implements ExternalNavigationAction {
        public static final int $stable = 8;
        private final Uri deeplinkUri;
        private final String defaultPackageName;

        public static /* synthetic */ OpenDeepLink copy$default(OpenDeepLink openDeepLink, Uri uri, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = openDeepLink.deeplinkUri;
            }
            if ((i & 2) != 0) {
                str = openDeepLink.defaultPackageName;
            }
            return openDeepLink.copy(uri, str);
        }

        public final Uri component1() {
            return this.deeplinkUri;
        }

        public final String component2() {
            return this.defaultPackageName;
        }

        public final OpenDeepLink copy(Uri deeplinkUri, String str) {
            Intrinsics.checkNotNullParameter(deeplinkUri, "deeplinkUri");
            return new OpenDeepLink(deeplinkUri, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OpenDeepLink) {
                OpenDeepLink openDeepLink = (OpenDeepLink) obj;
                return Intrinsics.areEqual(this.deeplinkUri, openDeepLink.deeplinkUri) && Intrinsics.areEqual(this.defaultPackageName, openDeepLink.defaultPackageName);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.deeplinkUri.hashCode() * 31;
            String str = this.defaultPackageName;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            Uri uri = this.deeplinkUri;
            return "OpenDeepLink(deeplinkUri=" + uri + ", defaultPackageName=" + this.defaultPackageName + ")";
        }

        public OpenDeepLink(Uri deeplinkUri, String str) {
            Intrinsics.checkNotNullParameter(deeplinkUri, "deeplinkUri");
            this.deeplinkUri = deeplinkUri;
            this.defaultPackageName = str;
        }

        public /* synthetic */ OpenDeepLink(Uri uri, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(uri, (i & 2) != 0 ? null : str);
        }

        public final Uri getDeeplinkUri() {
            return this.deeplinkUri;
        }

        public final String getDefaultPackageName() {
            return this.defaultPackageName;
        }
    }

    /* compiled from: ExternalNavigationAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction$DialPhoneNumber;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "phone", "", "<init>", "(Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "external-navigation_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DialPhoneNumber implements ExternalNavigationAction {
        public static final int $stable = 0;
        private final String phone;

        public static /* synthetic */ DialPhoneNumber copy$default(DialPhoneNumber dialPhoneNumber, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dialPhoneNumber.phone;
            }
            return dialPhoneNumber.copy(str);
        }

        public final String component1() {
            return this.phone;
        }

        public final DialPhoneNumber copy(String phone) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            return new DialPhoneNumber(phone);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DialPhoneNumber) && Intrinsics.areEqual(this.phone, ((DialPhoneNumber) obj).phone);
        }

        public int hashCode() {
            return this.phone.hashCode();
        }

        public String toString() {
            return "DialPhoneNumber(phone=" + this.phone + ")";
        }

        public DialPhoneNumber(String phone) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            this.phone = phone;
        }

        public final String getPhone() {
            return this.phone;
        }
    }
}
