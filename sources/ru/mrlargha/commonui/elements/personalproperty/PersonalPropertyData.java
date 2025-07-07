package ru.mrlargha.commonui.elements.personalproperty;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.quest.RodinaSerializableData;
/* compiled from: PersonalPropertyData.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyData;", "Lru/mrlargha/commonui/elements/quest/RodinaSerializableData;", "title", "", "description", "imageLink", "details", "", "Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyDetail;", "primaryButtonText", "secondaryButtonText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getImageLink", "getDetails", "()Ljava/util/List;", "getPrimaryButtonText", "getSecondaryButtonText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalPropertyData implements RodinaSerializableData {
    private final String description;
    private final List<PersonalPropertyDetail> details;
    private final String imageLink;
    private final String primaryButtonText;
    private final String secondaryButtonText;
    private final String title;

    public static /* synthetic */ PersonalPropertyData copy$default(PersonalPropertyData personalPropertyData, String str, String str2, String str3, List list, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = personalPropertyData.title;
        }
        if ((i & 2) != 0) {
            str2 = personalPropertyData.description;
        }
        if ((i & 4) != 0) {
            str3 = personalPropertyData.imageLink;
        }
        List<PersonalPropertyDetail> list2 = list;
        if ((i & 8) != 0) {
            list2 = personalPropertyData.details;
        }
        if ((i & 16) != 0) {
            str4 = personalPropertyData.primaryButtonText;
        }
        if ((i & 32) != 0) {
            str5 = personalPropertyData.secondaryButtonText;
        }
        String str6 = str4;
        String str7 = str5;
        return personalPropertyData.copy(str, str2, str3, list2, str6, str7);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.imageLink;
    }

    public final List<PersonalPropertyDetail> component4() {
        return this.details;
    }

    public final String component5() {
        return this.primaryButtonText;
    }

    public final String component6() {
        return this.secondaryButtonText;
    }

    public final PersonalPropertyData copy(String title, String description, String imageLink, List<PersonalPropertyDetail> details, String str, String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(imageLink, "imageLink");
        Intrinsics.checkNotNullParameter(details, "details");
        return new PersonalPropertyData(title, description, imageLink, details, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PersonalPropertyData) {
            PersonalPropertyData personalPropertyData = (PersonalPropertyData) obj;
            return Intrinsics.areEqual(this.title, personalPropertyData.title) && Intrinsics.areEqual(this.description, personalPropertyData.description) && Intrinsics.areEqual(this.imageLink, personalPropertyData.imageLink) && Intrinsics.areEqual(this.details, personalPropertyData.details) && Intrinsics.areEqual(this.primaryButtonText, personalPropertyData.primaryButtonText) && Intrinsics.areEqual(this.secondaryButtonText, personalPropertyData.secondaryButtonText);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.imageLink.hashCode()) * 31) + this.details.hashCode()) * 31;
        String str = this.primaryButtonText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.secondaryButtonText;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.description;
        String str3 = this.imageLink;
        List<PersonalPropertyDetail> list = this.details;
        String str4 = this.primaryButtonText;
        return "PersonalPropertyData(title=" + str + ", description=" + str2 + ", imageLink=" + str3 + ", details=" + list + ", primaryButtonText=" + str4 + ", secondaryButtonText=" + this.secondaryButtonText + ")";
    }

    public PersonalPropertyData(String title, String description, String imageLink, List<PersonalPropertyDetail> details, String str, String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(imageLink, "imageLink");
        Intrinsics.checkNotNullParameter(details, "details");
        this.title = title;
        this.description = description;
        this.imageLink = imageLink;
        this.details = details;
        this.primaryButtonText = str;
        this.secondaryButtonText = str2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImageLink() {
        return this.imageLink;
    }

    public /* synthetic */ PersonalPropertyData(String str, String str2, String str3, List list, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    public final List<PersonalPropertyDetail> getDetails() {
        return this.details;
    }

    public final String getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }
}
