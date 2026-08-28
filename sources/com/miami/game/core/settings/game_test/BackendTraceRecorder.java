package com.miami.game.core.settings.game_test;

import android.content.Context;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.miami.game.core.firebase.notification.NotificationStatsStore;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: BackendTraceRecorder.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0003\u0016\u0017\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendTraceRecorder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "activeSession", "Lcom/miami/game/core/settings/game_test/BackendTraceRecorder$TraceSession;", TtmlNode.START, "Ljava/io/File;", "traceName", "", "stop", "isActive", "", "record", "", "backendId", "", "backendName", "subId", "message", "TraceSession", "RecordedEvent", "Companion", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackendTraceRecorder {
    private static final Companion Companion = new Companion(null);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
    private static final String TRACE_DIR_NAME = "game-tests/backend-traces";
    private TraceSession activeSession;
    private final Context context;

    public BackendTraceRecorder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public static /* synthetic */ File start$default(BackendTraceRecorder backendTraceRecorder, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return backendTraceRecorder.start(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r9 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File start(String str) {
        String str2;
        String obj;
        if (str != null && (obj = StringsKt.trim((CharSequence) str).toString()) != null) {
            if (obj.length() <= 0) {
                obj = null;
            }
            if (obj != null) {
                str2 = new Regex("[^A-Za-z0-9._-]").replace(obj, "_");
            }
        }
        str2 = "backend_trace";
        String str3 = str2;
        String format = DATE_FORMAT.format(new Date());
        File file = new File(this.context.getFilesDir(), TRACE_DIR_NAME);
        file.mkdirs();
        File file2 = new File(file, format + "_" + str3 + ".json");
        this.activeSession = new TraceSession(str3, file2, System.currentTimeMillis(), null, new ArrayList());
        return file2;
    }

    public final File stop() {
        TraceSession traceSession = this.activeSession;
        if (traceSession == null) {
            return null;
        }
        JSONObject put = new JSONObject().put("name", traceSession.getName()).put("recordedAt", DATE_FORMAT.format(new Date(traceSession.getStartedAtMs())));
        JSONArray jSONArray = new JSONArray();
        for (RecordedEvent recordedEvent : traceSession.getEvents()) {
            jSONArray.put(new JSONObject().put("backendId", recordedEvent.getBackendId()).put("backendName", recordedEvent.getBackendName()).put("subId", recordedEvent.getSubId()).put("delayMs", recordedEvent.getDelayMs()).put("message", recordedEvent.toJsonMessage()));
        }
        Unit unit = Unit.INSTANCE;
        JSONObject put2 = put.put(NotificationStatsStore.KEY_EVENTS, jSONArray);
        File outputFile = traceSession.getOutputFile();
        String jSONObject = put2.toString(2);
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        FilesKt.writeText(outputFile, jSONObject, UTF_8);
        this.activeSession = null;
        return traceSession.getOutputFile();
    }

    public final boolean isActive() {
        return this.activeSession != null;
    }

    public final void record(int i, String backendName, int i2, String message) {
        Intrinsics.checkNotNullParameter(backendName, "backendName");
        Intrinsics.checkNotNullParameter(message, "message");
        TraceSession traceSession = this.activeSession;
        if (traceSession == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long lastEventAtMs = traceSession.getLastEventAtMs();
        long longValue = lastEventAtMs != null ? currentTimeMillis - lastEventAtMs.longValue() : 0L;
        traceSession.setLastEventAtMs(Long.valueOf(currentTimeMillis));
        traceSession.getEvents().add(new RecordedEvent(i, backendName, i2, message, RangesKt.coerceAtLeast(longValue, 0L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BackendTraceRecorder.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JH\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendTraceRecorder$TraceSession;", "", "name", "", "outputFile", "Ljava/io/File;", "startedAtMs", "", "lastEventAtMs", NotificationStatsStore.KEY_EVENTS, "", "Lcom/miami/game/core/settings/game_test/BackendTraceRecorder$RecordedEvent;", "<init>", "(Ljava/lang/String;Ljava/io/File;JLjava/lang/Long;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getOutputFile", "()Ljava/io/File;", "getStartedAtMs", "()J", "getLastEventAtMs", "()Ljava/lang/Long;", "setLastEventAtMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEvents", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/io/File;JLjava/lang/Long;Ljava/util/List;)Lcom/miami/game/core/settings/game_test/BackendTraceRecorder$TraceSession;", "equals", "", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TraceSession {
        private final List<RecordedEvent> events;
        private Long lastEventAtMs;
        private final String name;
        private final File outputFile;
        private final long startedAtMs;

        public static /* synthetic */ TraceSession copy$default(TraceSession traceSession, String str, File file, long j, Long l, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = traceSession.name;
            }
            if ((i & 2) != 0) {
                file = traceSession.outputFile;
            }
            if ((i & 4) != 0) {
                j = traceSession.startedAtMs;
            }
            if ((i & 8) != 0) {
                l = traceSession.lastEventAtMs;
            }
            List<RecordedEvent> list2 = list;
            if ((i & 16) != 0) {
                list2 = traceSession.events;
            }
            long j2 = j;
            return traceSession.copy(str, file, j2, l, list2);
        }

        public final String component1() {
            return this.name;
        }

        public final File component2() {
            return this.outputFile;
        }

        public final long component3() {
            return this.startedAtMs;
        }

        public final Long component4() {
            return this.lastEventAtMs;
        }

        public final List<RecordedEvent> component5() {
            return this.events;
        }

        public final TraceSession copy(String name, File outputFile, long j, Long l, List<RecordedEvent> events) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(outputFile, "outputFile");
            Intrinsics.checkNotNullParameter(events, "events");
            return new TraceSession(name, outputFile, j, l, events);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TraceSession) {
                TraceSession traceSession = (TraceSession) obj;
                return Intrinsics.areEqual(this.name, traceSession.name) && Intrinsics.areEqual(this.outputFile, traceSession.outputFile) && this.startedAtMs == traceSession.startedAtMs && Intrinsics.areEqual(this.lastEventAtMs, traceSession.lastEventAtMs) && Intrinsics.areEqual(this.events, traceSession.events);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.name.hashCode() * 31) + this.outputFile.hashCode()) * 31) + Long.hashCode(this.startedAtMs)) * 31;
            Long l = this.lastEventAtMs;
            return ((hashCode + (l == null ? 0 : l.hashCode())) * 31) + this.events.hashCode();
        }

        public String toString() {
            String str = this.name;
            File file = this.outputFile;
            long j = this.startedAtMs;
            Long l = this.lastEventAtMs;
            return "TraceSession(name=" + str + ", outputFile=" + file + ", startedAtMs=" + j + ", lastEventAtMs=" + l + ", events=" + this.events + ")";
        }

        public TraceSession(String name, File outputFile, long j, Long l, List<RecordedEvent> events) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(outputFile, "outputFile");
            Intrinsics.checkNotNullParameter(events, "events");
            this.name = name;
            this.outputFile = outputFile;
            this.startedAtMs = j;
            this.lastEventAtMs = l;
            this.events = events;
        }

        public final String getName() {
            return this.name;
        }

        public final File getOutputFile() {
            return this.outputFile;
        }

        public final long getStartedAtMs() {
            return this.startedAtMs;
        }

        public final Long getLastEventAtMs() {
            return this.lastEventAtMs;
        }

        public final void setLastEventAtMs(Long l) {
            this.lastEventAtMs = l;
        }

        public final List<RecordedEvent> getEvents() {
            return this.events;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BackendTraceRecorder.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0001J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendTraceRecorder$RecordedEvent;", "", "backendId", "", "backendName", "", "subId", "message", "delayMs", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;J)V", "getBackendId", "()I", "getBackendName", "()Ljava/lang/String;", "getSubId", "getMessage", "getDelayMs", "()J", "toJsonMessage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RecordedEvent {
        private final int backendId;
        private final String backendName;
        private final long delayMs;
        private final String message;
        private final int subId;

        public static /* synthetic */ RecordedEvent copy$default(RecordedEvent recordedEvent, int i, String str, int i2, String str2, long j, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = recordedEvent.backendId;
            }
            if ((i3 & 2) != 0) {
                str = recordedEvent.backendName;
            }
            if ((i3 & 4) != 0) {
                i2 = recordedEvent.subId;
            }
            if ((i3 & 8) != 0) {
                str2 = recordedEvent.message;
            }
            if ((i3 & 16) != 0) {
                j = recordedEvent.delayMs;
            }
            long j2 = j;
            return recordedEvent.copy(i, str, i2, str2, j2);
        }

        public final int component1() {
            return this.backendId;
        }

        public final String component2() {
            return this.backendName;
        }

        public final int component3() {
            return this.subId;
        }

        public final String component4() {
            return this.message;
        }

        public final long component5() {
            return this.delayMs;
        }

        public final RecordedEvent copy(int i, String backendName, int i2, String message, long j) {
            Intrinsics.checkNotNullParameter(backendName, "backendName");
            Intrinsics.checkNotNullParameter(message, "message");
            return new RecordedEvent(i, backendName, i2, message, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RecordedEvent) {
                RecordedEvent recordedEvent = (RecordedEvent) obj;
                return this.backendId == recordedEvent.backendId && Intrinsics.areEqual(this.backendName, recordedEvent.backendName) && this.subId == recordedEvent.subId && Intrinsics.areEqual(this.message, recordedEvent.message) && this.delayMs == recordedEvent.delayMs;
            }
            return false;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.backendId) * 31) + this.backendName.hashCode()) * 31) + Integer.hashCode(this.subId)) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.delayMs);
        }

        public String toString() {
            int i = this.backendId;
            String str = this.backendName;
            int i2 = this.subId;
            String str2 = this.message;
            return "RecordedEvent(backendId=" + i + ", backendName=" + str + ", subId=" + i2 + ", message=" + str2 + ", delayMs=" + this.delayMs + ")";
        }

        public RecordedEvent(int i, String backendName, int i2, String message, long j) {
            Intrinsics.checkNotNullParameter(backendName, "backendName");
            Intrinsics.checkNotNullParameter(message, "message");
            this.backendId = i;
            this.backendName = backendName;
            this.subId = i2;
            this.message = message;
            this.delayMs = j;
        }

        public final int getBackendId() {
            return this.backendId;
        }

        public final String getBackendName() {
            return this.backendName;
        }

        public final int getSubId() {
            return this.subId;
        }

        public final String getMessage() {
            return this.message;
        }

        public final long getDelayMs() {
            return this.delayMs;
        }

        public final Object toJsonMessage() {
            Object m9920constructorimpl;
            Object m9920constructorimpl2;
            try {
                Result.Companion companion = Result.Companion;
                RecordedEvent recordedEvent = this;
                m9920constructorimpl = Result.m9920constructorimpl(new JSONObject(this.message));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9923exceptionOrNullimpl(m9920constructorimpl) == null) {
                return m9920constructorimpl;
            }
            try {
                Result.Companion companion3 = Result.Companion;
                RecordedEvent recordedEvent2 = this;
                m9920constructorimpl2 = Result.m9920constructorimpl(new JSONArray(this.message));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                m9920constructorimpl2 = Result.m9920constructorimpl(ResultKt.createFailure(th2));
            }
            return Result.m9923exceptionOrNullimpl(m9920constructorimpl2) == null ? m9920constructorimpl2 : this.message;
        }
    }

    /* compiled from: BackendTraceRecorder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendTraceRecorder$Companion;", "", "<init>", "()V", "TRACE_DIR_NAME", "", "DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
