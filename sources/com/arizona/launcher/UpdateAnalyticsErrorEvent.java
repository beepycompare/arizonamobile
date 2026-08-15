package com.arizona.launcher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/arizona/launcher/UpdateAnalyticsErrorEvent;", "", "code", "", "errno", "Lcom/arizona/launcher/UpdateAnalyticsErrno;", "legacyCallSite", "context", "", "<init>", "(Ljava/lang/String;IILcom/arizona/launcher/UpdateAnalyticsErrno;ILjava/lang/String;)V", "getCode", "()I", "getErrno", "()Lcom/arizona/launcher/UpdateAnalyticsErrno;", "getLegacyCallSite", "getContext", "()Ljava/lang/String;", "GAME_UPDATE_SERVER_EMPTY", "GAME_UPDATE_REQUEST_FAILED", "GAME_DATA_SERVER_EMPTY", "GAME_DATA_FILE_LIST_EMPTY", "GAME_DATA_DELETE_TARGET_FAILED", "GAME_DATA_DOWNLOAD_FAILED", "GAME_DATA_DOWNLOAD_CANCELED", "GAME_DATA_DOWNLOAD_NOT_COMPLETED", "GAME_DATA_VALIDATION_FAILED", "LAUNCHER_UPDATE_CHECK_SERVER_EMPTY", "LAUNCHER_UPDATE_CHECK_JSON_INVALID", "LAUNCHER_UPDATE_CHECK_REQUEST_FAILED", "LAUNCHER_APK_SERVER_EMPTY", "LAUNCHER_APK_DOWNLOAD_FAILED", "LAUNCHER_APK_DOWNLOAD_CANCELED", "CHECK_AND_DOWNLOAD_SERVER_EMPTY", "CHECK_AND_DOWNLOAD_REQUEST_FAILED", "ARCHIVE_STORAGE_INSUFFICIENT", "ARCHIVE_FOREGROUND_UNAVAILABLE", "ARCHIVE_RECOVERY_BLOCKED", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateAnalyticsErrorEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UpdateAnalyticsErrorEvent[] $VALUES;
    private final int code;
    private final String context;
    private final UpdateAnalyticsErrno errno;
    private final int legacyCallSite;
    public static final UpdateAnalyticsErrorEvent GAME_UPDATE_SERVER_EMPTY = new UpdateAnalyticsErrorEvent("GAME_UPDATE_SERVER_EMPTY", 0, 1001, UpdateAnalyticsErrno.UpdateServerUnreachable, 337, "Не найден URL сервера для проверки игровых файлов");
    public static final UpdateAnalyticsErrorEvent GAME_UPDATE_REQUEST_FAILED = new UpdateAnalyticsErrorEvent("GAME_UPDATE_REQUEST_FAILED", 1, 1002, UpdateAnalyticsErrno.UpdateServerUnreachable, 404, "Запрос update json для игровых файлов завершился ошибкой");
    public static final UpdateAnalyticsErrorEvent GAME_DATA_SERVER_EMPTY = new UpdateAnalyticsErrorEvent("GAME_DATA_SERVER_EMPTY", 2, 1003, UpdateAnalyticsErrno.UpdateServerUnreachable, 478, "Не найден URL сервера перед скачиванием игровых файлов");
    public static final UpdateAnalyticsErrorEvent GAME_DATA_FILE_LIST_EMPTY = new UpdateAnalyticsErrorEvent("GAME_DATA_FILE_LIST_EMPTY", 3, 1004, UpdateAnalyticsErrno.ConnectionRefused, 495, "Запуск скачивания без списка файлов для обновления");
    public static final UpdateAnalyticsErrorEvent GAME_DATA_DELETE_TARGET_FAILED = new UpdateAnalyticsErrorEvent("GAME_DATA_DELETE_TARGET_FAILED", 4, 1005, UpdateAnalyticsErrno.CorruptedFilesFound, 536, "Не удалось удалить старый файл перед повторной загрузкой");
    public static final UpdateAnalyticsErrorEvent GAME_DATA_DOWNLOAD_FAILED = new UpdateAnalyticsErrorEvent("GAME_DATA_DOWNLOAD_FAILED", 5, 1006, UpdateAnalyticsErrno.ConnectionRefused, 592, "Скачивание игровых файлов завершилось ошибкой");
    public static final UpdateAnalyticsErrorEvent GAME_DATA_DOWNLOAD_CANCELED = new UpdateAnalyticsErrorEvent("GAME_DATA_DOWNLOAD_CANCELED", 6, 1007, UpdateAnalyticsErrno.ConnectionRefused, 592, "Скачивание игровых файлов было отменено");
    public static final UpdateAnalyticsErrorEvent GAME_DATA_DOWNLOAD_NOT_COMPLETED = new UpdateAnalyticsErrorEvent("GAME_DATA_DOWNLOAD_NOT_COMPLETED", 7, 1008, UpdateAnalyticsErrno.ConnectionRefused, 592, "Скачивание игровых файлов завершилось без успешного статуса");
    public static final UpdateAnalyticsErrorEvent GAME_DATA_VALIDATION_FAILED = new UpdateAnalyticsErrorEvent("GAME_DATA_VALIDATION_FAILED", 8, 1009, UpdateAnalyticsErrno.CorruptedFilesFound, 644, "После скачивания проверка файлов нашла повреждения");
    public static final UpdateAnalyticsErrorEvent LAUNCHER_UPDATE_CHECK_SERVER_EMPTY = new UpdateAnalyticsErrorEvent("LAUNCHER_UPDATE_CHECK_SERVER_EMPTY", 9, 1010, UpdateAnalyticsErrno.UpdateServerUnreachable, 807, "Не найден URL сервера для проверки обновления лаунчера");
    public static final UpdateAnalyticsErrorEvent LAUNCHER_UPDATE_CHECK_JSON_INVALID = new UpdateAnalyticsErrorEvent("LAUNCHER_UPDATE_CHECK_JSON_INVALID", 10, 1011, UpdateAnalyticsErrno.UpdateServerUnreachable, 868, "Ответ app_version json не удалось разобрать");
    public static final UpdateAnalyticsErrorEvent LAUNCHER_UPDATE_CHECK_REQUEST_FAILED = new UpdateAnalyticsErrorEvent("LAUNCHER_UPDATE_CHECK_REQUEST_FAILED", 11, 1012, UpdateAnalyticsErrno.UpdateServerUnreachable, 868, "Запрос app_version json завершился ошибкой");
    public static final UpdateAnalyticsErrorEvent LAUNCHER_APK_SERVER_EMPTY = new UpdateAnalyticsErrorEvent("LAUNCHER_APK_SERVER_EMPTY", 12, 1013, UpdateAnalyticsErrno.UpdateServerUnreachable, 900, "Не найден URL сервера перед скачиванием APK лаунчера");
    public static final UpdateAnalyticsErrorEvent LAUNCHER_APK_DOWNLOAD_FAILED = new UpdateAnalyticsErrorEvent("LAUNCHER_APK_DOWNLOAD_FAILED", 13, 1014, UpdateAnalyticsErrno.UpdateServerUnreachable, 960, "Скачивание APK лаунчера завершилось ошибкой");
    public static final UpdateAnalyticsErrorEvent LAUNCHER_APK_DOWNLOAD_CANCELED = new UpdateAnalyticsErrorEvent("LAUNCHER_APK_DOWNLOAD_CANCELED", 14, 1015, UpdateAnalyticsErrno.UpdateServerUnreachable, 960, "Скачивание APK лаунчера было отменено");
    public static final UpdateAnalyticsErrorEvent CHECK_AND_DOWNLOAD_SERVER_EMPTY = new UpdateAnalyticsErrorEvent("CHECK_AND_DOWNLOAD_SERVER_EMPTY", 15, 1016, UpdateAnalyticsErrno.UpdateServerUnreachable, 1110, "Не найден URL сервера в combined flow проверки и загрузки");
    public static final UpdateAnalyticsErrorEvent CHECK_AND_DOWNLOAD_REQUEST_FAILED = new UpdateAnalyticsErrorEvent("CHECK_AND_DOWNLOAD_REQUEST_FAILED", 16, 1017, UpdateAnalyticsErrno.UpdateServerUnreachable, 1238, "Combined flow не получил update json после доступных попыток");
    public static final UpdateAnalyticsErrorEvent ARCHIVE_STORAGE_INSUFFICIENT = new UpdateAnalyticsErrorEvent("ARCHIVE_STORAGE_INSUFFICIENT", 17, 1018, UpdateAnalyticsErrno.InsufficientStorage, 1380, "Недостаточно места на томе игровых данных для архивной установки");
    public static final UpdateAnalyticsErrorEvent ARCHIVE_FOREGROUND_UNAVAILABLE = new UpdateAnalyticsErrorEvent("ARCHIVE_FOREGROUND_UNAVAILABLE", 18, 1019, UpdateAnalyticsErrno.ForegroundServiceUnavailable, 1390, "Архивная загрузка не запущена без foreground-гарантии");
    public static final UpdateAnalyticsErrorEvent ARCHIVE_RECOVERY_BLOCKED = new UpdateAnalyticsErrorEvent("ARCHIVE_RECOVERY_BLOCKED", 19, 1020, UpdateAnalyticsErrno.ArchiveRecoveryBlocked, TypedValues.TransitionType.TYPE_DURATION, "Архивная транзакция требует безопасного внешнего восстановления");

    private static final /* synthetic */ UpdateAnalyticsErrorEvent[] $values() {
        return new UpdateAnalyticsErrorEvent[]{GAME_UPDATE_SERVER_EMPTY, GAME_UPDATE_REQUEST_FAILED, GAME_DATA_SERVER_EMPTY, GAME_DATA_FILE_LIST_EMPTY, GAME_DATA_DELETE_TARGET_FAILED, GAME_DATA_DOWNLOAD_FAILED, GAME_DATA_DOWNLOAD_CANCELED, GAME_DATA_DOWNLOAD_NOT_COMPLETED, GAME_DATA_VALIDATION_FAILED, LAUNCHER_UPDATE_CHECK_SERVER_EMPTY, LAUNCHER_UPDATE_CHECK_JSON_INVALID, LAUNCHER_UPDATE_CHECK_REQUEST_FAILED, LAUNCHER_APK_SERVER_EMPTY, LAUNCHER_APK_DOWNLOAD_FAILED, LAUNCHER_APK_DOWNLOAD_CANCELED, CHECK_AND_DOWNLOAD_SERVER_EMPTY, CHECK_AND_DOWNLOAD_REQUEST_FAILED, ARCHIVE_STORAGE_INSUFFICIENT, ARCHIVE_FOREGROUND_UNAVAILABLE, ARCHIVE_RECOVERY_BLOCKED};
    }

    public static EnumEntries<UpdateAnalyticsErrorEvent> getEntries() {
        return $ENTRIES;
    }

    public static UpdateAnalyticsErrorEvent valueOf(String str) {
        return (UpdateAnalyticsErrorEvent) Enum.valueOf(UpdateAnalyticsErrorEvent.class, str);
    }

    public static UpdateAnalyticsErrorEvent[] values() {
        return (UpdateAnalyticsErrorEvent[]) $VALUES.clone();
    }

    private UpdateAnalyticsErrorEvent(String str, int i, int i2, UpdateAnalyticsErrno updateAnalyticsErrno, int i3, String str2) {
        this.code = i2;
        this.errno = updateAnalyticsErrno;
        this.legacyCallSite = i3;
        this.context = str2;
    }

    public final int getCode() {
        return this.code;
    }

    public final UpdateAnalyticsErrno getErrno() {
        return this.errno;
    }

    public final int getLegacyCallSite() {
        return this.legacyCallSite;
    }

    public final String getContext() {
        return this.context;
    }

    static {
        UpdateAnalyticsErrorEvent[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
