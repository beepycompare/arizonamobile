package ru.mrlargha.commonui.elements.quest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Quest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/quest/StoryLine;", "", "id", "", "type", "title", "", "image", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getType", "getTitle", "()Ljava/lang/String;", "getImage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StoryLine {
    private final int id;
    private final String image;
    private final String title;
    private final int type;

    public static /* synthetic */ StoryLine copy$default(StoryLine storyLine, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = storyLine.id;
        }
        if ((i3 & 2) != 0) {
            i2 = storyLine.type;
        }
        if ((i3 & 4) != 0) {
            str = storyLine.title;
        }
        if ((i3 & 8) != 0) {
            str2 = storyLine.image;
        }
        return storyLine.copy(i, i2, str, str2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.image;
    }

    public final StoryLine copy(int i, int i2, String title, String image) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        return new StoryLine(i, i2, title, image);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StoryLine) {
            StoryLine storyLine = (StoryLine) obj;
            return this.id == storyLine.id && this.type == storyLine.type && Intrinsics.areEqual(this.title, storyLine.title) && Intrinsics.areEqual(this.image, storyLine.image);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.type)) * 31) + this.title.hashCode()) * 31) + this.image.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.type;
        String str = this.title;
        return "StoryLine(id=" + i + ", type=" + i2 + ", title=" + str + ", image=" + this.image + ")";
    }

    public StoryLine(int i, int i2, String title, String image) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        this.id = i;
        this.type = i2;
        this.title = title;
        this.image = image;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }
}
