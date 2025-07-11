package ru.mrlargha.commonui.elements.video_advice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VideoAdvice.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/video_advice/VideoAdviceIds;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "PLAY_VIDEO", "CLOSE_VIDEO", "SHOW_SKIP_QUEST", "STOP_VIDEO", "SKIP_QUEST", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoAdviceIds {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoAdviceIds[] $VALUES;
    private final int subId;
    public static final VideoAdviceIds PLAY_VIDEO = new VideoAdviceIds("PLAY_VIDEO", 0, 0);
    public static final VideoAdviceIds CLOSE_VIDEO = new VideoAdviceIds("CLOSE_VIDEO", 1, 1);
    public static final VideoAdviceIds SHOW_SKIP_QUEST = new VideoAdviceIds("SHOW_SKIP_QUEST", 2, 2);
    public static final VideoAdviceIds STOP_VIDEO = new VideoAdviceIds("STOP_VIDEO", 3, 0);
    public static final VideoAdviceIds SKIP_QUEST = new VideoAdviceIds("SKIP_QUEST", 4, 1);

    private static final /* synthetic */ VideoAdviceIds[] $values() {
        return new VideoAdviceIds[]{PLAY_VIDEO, CLOSE_VIDEO, SHOW_SKIP_QUEST, STOP_VIDEO, SKIP_QUEST};
    }

    public static EnumEntries<VideoAdviceIds> getEntries() {
        return $ENTRIES;
    }

    public static VideoAdviceIds valueOf(String str) {
        return (VideoAdviceIds) Enum.valueOf(VideoAdviceIds.class, str);
    }

    public static VideoAdviceIds[] values() {
        return (VideoAdviceIds[]) $VALUES.clone();
    }

    private VideoAdviceIds(String str, int i, int i2) {
        this.subId = i2;
    }

    public final int getSubId() {
        return this.subId;
    }

    static {
        VideoAdviceIds[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
