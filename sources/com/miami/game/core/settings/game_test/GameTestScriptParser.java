package com.miami.game.core.settings.game_test;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.miami.game.core.settings.game_test.GameTestStep;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: GameTestScriptParser.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0007H\u0002J$\u0010!\u001a\u00020\u001f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\f\u0010'\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010(\u001a\u00020)*\u00020\u0007H\u0002J$\u0010*\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00070+*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010,\u001a\u00020-*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0014\u0010.\u001a\u00020\u0007*\u00020\u000f2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0014\u00100\u001a\u000201*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u00102\u001a\u00020\u0007*\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u00103\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u00104\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u00105\u001a\u000206*\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u00107\u001a\u000208*\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00109\u001a\u000206*\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010:\u001a\u0002062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010;\u001a\u000206*\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010:\u001a\u0002062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001b\u0010<\u001a\u0004\u0018\u000106*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010=¨\u0006>"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptParser;", "", "<init>", "()V", "parse", "Lcom/miami/game/core/settings/game_test/GameTestScript;", "rawScript", "", "parseSteps", "", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "array", "Lorg/json/JSONArray;", "parseStep", "stepObject", "Lorg/json/JSONObject;", FirebaseAnalytics.Param.INDEX, "", "parseNotifyClick", "Lcom/miami/game/core/settings/game_test/GameTestStep$NotifyClick;", "parseShowUi", "Lcom/miami/game/core/settings/game_test/GameTestStep$ShowUi;", "parseHideUi", "Lcom/miami/game/core/settings/game_test/GameTestStep$HideUi;", "parseBackendMessage", "Lcom/miami/game/core/settings/game_test/GameTestStep$BackendMessage;", "parseWaitBackendMessage", "Lcom/miami/game/core/settings/game_test/GameTestStep$WaitBackendMessage;", "parseAddBackendMessageListener", "Lcom/miami/game/core/settings/game_test/GameTestStep$AddBackendMessageListener;", "parseBackendMessageListeners", "Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "owner", "parseBackendMessageListener", "defaultName", "parseReplayBackendFixture", "Lcom/miami/game/core/settings/game_test/GameTestStep$ReplayBackendFixture;", "parseStartBackendValidation", "Lcom/miami/game/core/settings/game_test/GameTestStep$StartBackendValidation;", "normalizeAction", "toStartTrigger", "Lcom/miami/game/core/settings/game_test/GameTestStartTrigger;", "parseBackendReference", "Lkotlin/Pair;", "parseBackendMessageMatcher", "Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "extractRawMessage", "key", "optReplayTarget", "Lcom/miami/game/core/settings/game_test/BackendReplayTarget;", "requireString", "requireInt", "requirePositiveInt", "requireNonNegativeLong", "", "requirePercent", "", "optNonNegativeLong", "defaultValue", "optPositiveLong", "optTimeoutMs", "(Lorg/json/JSONObject;I)Ljava/lang/Long;", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GameTestScriptParser {
    public static final GameTestScriptParser INSTANCE = new GameTestScriptParser();

    private GameTestScriptParser() {
    }

    @JvmStatic
    public static final GameTestScript parse(String rawScript) {
        List<GameTestBackendMessageListener> emptyList;
        Intrinsics.checkNotNullParameter(rawScript, "rawScript");
        JSONObject jSONObject = new JSONObject(rawScript);
        JSONArray optJSONArray = jSONObject.optJSONArray("steps");
        if (optJSONArray == null) {
            throw new IllegalArgumentException("Test script must contain a 'steps' array");
        }
        String optString = jSONObject.optString("name");
        if (StringsKt.isBlank(optString)) {
            optString = "game_test_script";
        }
        String str = optString;
        GameTestScriptParser gameTestScriptParser = INSTANCE;
        String optString2 = jSONObject.optString("startTrigger");
        if (StringsKt.isBlank(optString2)) {
            optString2 = "on_login";
        }
        Intrinsics.checkNotNullExpressionValue(optString2, "ifBlank(...)");
        GameTestStartTrigger startTrigger = gameTestScriptParser.toStartTrigger(optString2);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("listeners");
        if (optJSONArray2 == null || (emptyList = gameTestScriptParser.parseBackendMessageListeners(optJSONArray2, "Top-level listeners")) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<GameTestStep> parseSteps = gameTestScriptParser.parseSteps(optJSONArray);
        if (parseSteps.isEmpty()) {
            throw new IllegalArgumentException("Test script must contain at least one step");
        }
        Intrinsics.checkNotNull(str);
        return new GameTestScript(str, startTrigger, emptyList, parseSteps);
    }

    private final List<GameTestStep> parseSteps(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
            arrayList.add(parseStep(jSONObject, i));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01ac, code lost:
        return new com.miami.game.core.settings.game_test.GameTestStep.Chat(requireString(r16, "text", r17));
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b4, code lost:
        if (r2.equals("tap") != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01d6, code lost:
        if (r2.equals("stop_backend_listener") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01e1, code lost:
        if (r2.equals("listen_backend_message") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01eb, code lost:
        if (r2.equals("screenshot") != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01f6, code lost:
        if (r2.equals("listen_for_backend_message") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r2.equals("notify_click") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01fe, code lost:
        return parseAddBackendMessageListener(r16, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0206, code lost:
        if (r2.equals("close_all") != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x020c, code lost:
        return com.miami.game.core.settings.game_test.GameTestStep.CloseAll.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0214, code lost:
        if (r2.equals("backend_validation_stop") != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x021f, code lost:
        if (r2.equals("replay_fixture") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x022a, code lost:
        if (r2.equals("stop_backend_validation") != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0235, code lost:
        if (r2.equals("backend_validation_start") != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0240, code lost:
        if (r2.equals("backend_message") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0248, code lost:
        return parseBackendMessage(r16, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        if (r2.equals("backend_fixture") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0290, code lost:
        if (r2.equals("remove_backend_message_listener") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x029d, code lost:
        return new com.miami.game.core.settings.game_test.GameTestStep.RemoveBackendMessageListener(requireString(r16, "name", r17));
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02a5, code lost:
        if (r2.equals("tap_screen") != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02c8, code lost:
        return new com.miami.game.core.settings.game_test.GameTestStep.Tap(requirePercent(r16, "xPercent", r17), requirePercent(r16, "yPercent", r17), optNonNegativeLong(r16, "holdMs", 60, r17));
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02d0, code lost:
        if (r2.equals("stop_validation") != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02d6, code lost:
        return com.miami.game.core.settings.game_test.GameTestStep.StopBackendValidation.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02de, code lost:
        if (r2.equals("wait_for_backend_message") != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02e6, code lost:
        return parseWaitBackendMessage(r16, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02ee, code lost:
        if (r2.equals("replay_backend_fixture") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02f6, code lost:
        return parseReplayBackendFixture(r16, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02fe, code lost:
        if (r2.equals("open_ui") != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0306, code lost:
        return parseShowUi(r16, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x030e, code lost:
        if (r2.equals("backend_trace_stop") != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0314, code lost:
        return com.miami.game.core.settings.game_test.GameTestStep.StopBackendTrace.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x031c, code lost:
        if (r2.equals("clear_backend_message_listeners") != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (r2.equals("remove_backend_listener") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0322, code lost:
        return com.miami.game.core.settings.game_test.GameTestStep.ClearBackendMessageListeners.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x032a, code lost:
        if (r2.equals("capture_screen") != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0334, code lost:
        if (r2.equals("capture_screenshot") != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0336, code lost:
        r15 = r16.optString("fileName");
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0342, code lost:
        if (kotlin.text.StringsKt.isBlank(r15) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0344, code lost:
        r15 = r16.optString("name");
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x034e, code lost:
        if (kotlin.text.StringsKt.isBlank(r15) == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0351, code lost:
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0352, code lost:
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x035e, code lost:
        return new com.miami.game.core.settings.game_test.GameTestStep.Screenshot(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0366, code lost:
        if (r2.equals("start_validation") != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x036e, code lost:
        return parseStartBackendValidation(r16, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (r2.equals("add_backend_message_listener") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
        if (r2.equals("start_backend_trace") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
        if (r2.equals("backend_trace_start") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
        r15 = r16.optString("traceName");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
        if (kotlin.text.StringsKt.isBlank(r15) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0086, code lost:
        return new com.miami.game.core.settings.game_test.GameTestStep.StartBackendTrace(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
        if (r2.equals("wait_backend_message") != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
        if (r2.equals("closeall") != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b0, code lost:
        if (r2.equals("frontend_message") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ba, code lost:
        if (r2.equals("wait_frontend_message") != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c4, code lost:
        if (r2.equals("clear_backend_listeners") != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ce, code lost:
        if (r2.equals("stop_backend_trace") != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d8, code lost:
        if (r2.equals("start_backend_validation") != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e2, code lost:
        if (r2.equals("wait_for_frontend_message") != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ec, code lost:
        if (r2.equals("await_backend_message") != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r2.equals("mock_backend_message") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0100, code lost:
        if (r2.equals("add_backend_listener") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x010a, code lost:
        if (r2.equals("touch") != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014d, code lost:
        if (r2.equals("sleep") != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0157, code lost:
        if (r2.equals("input") != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0161, code lost:
        if (r2.equals("delay") != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x016b, code lost:
        if (r2.equals("click") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0173, code lost:
        return parseNotifyClick(r16, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r2.equals("show_ui") != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x017b, code lost:
        if (r2.equals("wait") != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018a, code lost:
        return new com.miami.game.core.settings.game_test.GameTestStep.Sleep(requireNonNegativeLong(r16, "delayMs", r17));
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0192, code lost:
        if (r2.equals("shot") != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x019d, code lost:
        if (r2.equals("chat") != false) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GameTestStep parseStep(JSONObject jSONObject, int i) {
        String str;
        String optString = jSONObject.optString("action");
        if (StringsKt.isBlank(optString)) {
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain a non-empty 'action'");
        }
        Intrinsics.checkNotNullExpressionValue(optString, "ifBlank(...)");
        String normalizeAction = normalizeAction(optString);
        String str2 = null;
        switch (normalizeAction.hashCode()) {
            case -1843812234:
                str = "action";
                break;
            case -1646466049:
                str = "action";
                break;
            case -1594205307:
                str = "action";
                break;
            case -1424311382:
                str = "action";
                break;
            case -1337328313:
                str = "action";
                break;
            case -1263193943:
                str = "action";
                break;
            case -1257716986:
                str = "action";
                break;
            case -1147610084:
                str = "action";
                break;
            case -1126309674:
                str = "action";
                break;
            case -1123110776:
                str = "action";
                break;
            case -978363502:
                str = "action";
                break;
            case -934531685:
                str = "action";
                if (normalizeAction.equals("repeat")) {
                    int requirePositiveInt = requirePositiveInt(jSONObject, "times", i);
                    JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                    if (optJSONArray != null) {
                        return new GameTestStep.Repeat(requirePositiveInt, parseSteps(optJSONArray));
                    }
                    throw new IllegalArgumentException("Repeat step #" + (i + 1) + " must contain a 'steps' array");
                }
                throw new IllegalArgumentException("Unsupported action '" + jSONObject.optString(str) + "' in step #" + (i + 1));
            case -722282148:
                str = "action";
                break;
            case -680966297:
                str = "action";
                break;
            case -620339615:
                str = "action";
                break;
            case -618720847:
                str = "action";
                break;
            case -576155555:
                str = "action";
                break;
            case -482161958:
                str = "action";
                break;
            case -418186386:
                str = "action";
                break;
            case -416447130:
                str = "action";
                break;
            case -357642524:
                str = "action";
                break;
            case -285723492:
                str = "action";
                break;
            case 107332:
                str = "action";
                if (normalizeAction.equals("log")) {
                    return new GameTestStep.Log(requireString(jSONObject, "message", i));
                }
                throw new IllegalArgumentException("Unsupported action '" + jSONObject.optString(str) + "' in step #" + (i + 1));
            case 114595:
                str = "action";
                break;
            case 3052376:
                str = "action";
                break;
            case 3529466:
                str = "action";
                break;
            case 3641717:
                str = "action";
                break;
            case 94750088:
                str = "action";
                break;
            case 95467907:
                str = "action";
                break;
            case 100358090:
                str = "action";
                break;
            case 109522647:
                str = "action";
                break;
            case 109854522:
                if (normalizeAction.equals("swipe")) {
                    return new GameTestStep.Swipe(requirePercent(jSONObject, "fromXPercent", i), requirePercent(jSONObject, "fromYPercent", i), requirePercent(jSONObject, "toXPercent", i), requirePercent(jSONObject, "toYPercent", i), optPositiveLong(jSONObject, "durationMs", 300L, i));
                }
                str = "action";
                throw new IllegalArgumentException("Unsupported action '" + jSONObject.optString(str) + "' in step #" + (i + 1));
            case 110550847:
                break;
            case 135673309:
                break;
            case 306648231:
                break;
            case 379665523:
                break;
            case 534992922:
                break;
            case 575702529:
                break;
            case 638372445:
                break;
            case 655962338:
                break;
            case 758860900:
                break;
            case 835257050:
                break;
            case 912619185:
                if (normalizeAction.equals("hide_ui")) {
                    return parseHideUi(jSONObject, i);
                }
                str = "action";
                throw new IllegalArgumentException("Unsupported action '" + jSONObject.optString(str) + "' in step #" + (i + 1));
            case 1092827305:
                break;
            case 1353463442:
                break;
            case 1492481981:
                break;
            case 1571839677:
                break;
            case 1709655573:
                break;
            case 1735792730:
                break;
            case 1774310238:
                break;
            case 1797481746:
                break;
            case 2067290902:
                break;
            default:
                str = "action";
                throw new IllegalArgumentException("Unsupported action '" + jSONObject.optString(str) + "' in step #" + (i + 1));
        }
    }

    private final GameTestStep.NotifyClick parseNotifyClick(JSONObject jSONObject, int i) {
        Pair<Integer, String> parseBackendReference = parseBackendReference(jSONObject, i);
        Integer component1 = parseBackendReference.component1();
        String component2 = parseBackendReference.component2();
        if (component1 == null && component2 == null) {
            throw new IllegalArgumentException("Click step #" + (i + 1) + " must contain 'backendId' or 'backendName'");
        }
        int requireInt = requireInt(jSONObject, "id", i);
        int optInt = jSONObject.optInt("subId", -1);
        String optString = jSONObject.optString("message");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return new GameTestStep.NotifyClick(component1, component2, requireInt, optInt, optString);
    }

    private final GameTestStep.ShowUi parseShowUi(JSONObject jSONObject, int i) {
        Pair<Integer, String> parseBackendReference = parseBackendReference(jSONObject, i);
        Integer component1 = parseBackendReference.component1();
        String component2 = parseBackendReference.component2();
        if (component1 == null && component2 == null) {
            throw new IllegalArgumentException("Show UI step #" + (i + 1) + " must contain 'backendId' or 'backendName'");
        }
        return new GameTestStep.ShowUi(component1, component2, jSONObject.optBoolean("exclusive", false));
    }

    private final GameTestStep.HideUi parseHideUi(JSONObject jSONObject, int i) {
        Pair<Integer, String> parseBackendReference = parseBackendReference(jSONObject, i);
        Integer component1 = parseBackendReference.component1();
        String component2 = parseBackendReference.component2();
        if (component1 == null && component2 == null) {
            throw new IllegalArgumentException("Hide UI step #" + (i + 1) + " must contain 'backendId' or 'backendName'");
        }
        return new GameTestStep.HideUi(component1, component2);
    }

    private final GameTestStep.BackendMessage parseBackendMessage(JSONObject jSONObject, int i) {
        Pair<Integer, String> parseBackendReference = parseBackendReference(jSONObject, i);
        Integer component1 = parseBackendReference.component1();
        String component2 = parseBackendReference.component2();
        if (component1 == null && component2 == null) {
            throw new IllegalArgumentException("Backend message step #" + (i + 1) + " must contain 'backendId' or 'backendName'");
        }
        int requireInt = requireInt(jSONObject, "subId", i);
        String extractRawMessage = extractRawMessage(jSONObject, "message");
        BackendReplayTarget optReplayTarget = optReplayTarget(jSONObject, i);
        String optString = jSONObject.optString("provider");
        if (StringsKt.isBlank(optString)) {
            optString = null;
        }
        return new GameTestStep.BackendMessage(component1, component2, requireInt, extractRawMessage, optReplayTarget, optString);
    }

    private final GameTestStep.WaitBackendMessage parseWaitBackendMessage(JSONObject jSONObject, int i) {
        return new GameTestStep.WaitBackendMessage(parseBackendMessageMatcher(jSONObject, i, "Wait backend message step"), optTimeoutMs(jSONObject, i), jSONObject.optBoolean("includePast", true), jSONObject.optBoolean("failOnTimeout", true));
    }

    private final GameTestStep.AddBackendMessageListener parseAddBackendMessageListener(JSONObject jSONObject, int i) {
        return new GameTestStep.AddBackendMessageListener(parseBackendMessageListener(jSONObject, i, "Backend listener step", "listener_step_" + (i + 1)));
    }

    private final List<GameTestBackendMessageListener> parseBackendMessageListeners(JSONArray jSONArray, String str) {
        List createListBuilder = CollectionsKt.createListBuilder();
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            GameTestScriptParser gameTestScriptParser = INSTANCE;
            Intrinsics.checkNotNull(jSONObject);
            int i2 = i + 1;
            createListBuilder.add(gameTestScriptParser.parseBackendMessageListener(jSONObject, i, str, "listener_" + i2));
            i = i2;
        }
        return CollectionsKt.build(createListBuilder);
    }

    private final GameTestBackendMessageListener parseBackendMessageListener(JSONObject jSONObject, int i, String str, String str2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("steps");
        if (optJSONArray == null) {
            throw new IllegalArgumentException(str + " #" + (i + 1) + " must contain a 'steps' array");
        }
        List<GameTestStep> parseSteps = parseSteps(optJSONArray);
        if (parseSteps.isEmpty()) {
            throw new IllegalArgumentException(str + " #" + (i + 1) + " must contain at least one nested step");
        }
        String optString = jSONObject.optString("name");
        if (!StringsKt.isBlank(optString)) {
            str2 = optString;
        }
        Intrinsics.checkNotNullExpressionValue(str2, "ifBlank(...)");
        return new GameTestBackendMessageListener(str2, parseBackendMessageMatcher(jSONObject, i, str), jSONObject.optBoolean("once", false), parseSteps);
    }

    private final GameTestStep.ReplayBackendFixture parseReplayBackendFixture(JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("fixture");
        if (StringsKt.isBlank(optString)) {
            optString = jSONObject.optString("path");
        }
        String str = optString;
        if (StringsKt.isBlank(str)) {
            throw new IllegalArgumentException("Replay backend fixture step #" + (i + 1) + " must contain 'fixture' or 'path'");
        }
        String str2 = str;
        Intrinsics.checkNotNull(str2);
        BackendReplayTarget optReplayTarget = optReplayTarget(jSONObject, i);
        String optString2 = jSONObject.optString("provider");
        if (StringsKt.isBlank(optString2)) {
            optString2 = null;
        }
        return new GameTestStep.ReplayBackendFixture(str2, optReplayTarget, optString2);
    }

    private final GameTestStep.StartBackendValidation parseStartBackendValidation(JSONObject jSONObject, int i) {
        Pair<Integer, String> parseBackendReference;
        String optString;
        String optString2;
        if (jSONObject.has("backendId") || (((optString = jSONObject.optString("backendName")) != null && !StringsKt.isBlank(optString)) || ((optString2 = jSONObject.optString("backend")) != null && !StringsKt.isBlank(optString2)))) {
            parseBackendReference = parseBackendReference(jSONObject, i);
        } else {
            parseBackendReference = TuplesKt.to(null, null);
        }
        Integer component1 = parseBackendReference.component1();
        String component2 = parseBackendReference.component2();
        String optString3 = jSONObject.optString("validationName");
        if (StringsKt.isBlank(optString3)) {
            String optString4 = jSONObject.optString("sessionName");
            if (StringsKt.isBlank(optString4)) {
                optString4 = null;
            }
            optString3 = optString4;
        }
        String str = optString3;
        String optString5 = jSONObject.optString("provider");
        return new GameTestStep.StartBackendValidation(str, StringsKt.isBlank(optString5) ? null : optString5, component1, component2);
    }

    private final String normalizeAction(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.replace$default(StringsKt.replace$default(lowerCase, Constants.FILENAME_SEQUENCE_SEPARATOR, "_", false, 4, (Object) null), " ", "_", false, 4, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r2.equals("on_manual") != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r2.equals("immediate") != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r2.equals("game_ready") != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r2.equals("on_game_ready") != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        return com.miami.game.core.settings.game_test.GameTestStartTrigger.ON_GAME_READY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r2.equals("manual") != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
        return com.miami.game.core.settings.game_test.GameTestStartTrigger.MANUAL;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GameTestStartTrigger toStartTrigger(String str) {
        String normalizeAction = normalizeAction(str);
        switch (normalizeAction.hashCode()) {
            case -1081415738:
                break;
            case 868581750:
                break;
            case 969034518:
                break;
            case 1124382641:
                break;
            case 1298681382:
                break;
            case 1842494729:
                if (normalizeAction.equals("on_login")) {
                    return GameTestStartTrigger.ON_LOGIN;
                }
                throw new IllegalArgumentException("Unsupported startTrigger '" + str + "'");
            default:
                throw new IllegalArgumentException("Unsupported startTrigger '" + str + "'");
        }
    }

    private final Pair<Integer, String> parseBackendReference(JSONObject jSONObject, int i) {
        Integer valueOf = jSONObject.has("backendId") ? Integer.valueOf(jSONObject.getInt("backendId")) : null;
        String optString = jSONObject.optString("backendName");
        if (StringsKt.isBlank(optString)) {
            String optString2 = jSONObject.optString("backend");
            optString = StringsKt.isBlank(optString2) ? null : optString2;
        }
        String str = optString;
        if (valueOf == null && str == null) {
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain 'backendId' or 'backendName'");
        }
        return TuplesKt.to(valueOf, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BackendMessageMatcher parseBackendMessageMatcher(JSONObject jSONObject, int i, String str) {
        Integer num;
        Integer valueOf;
        String optString;
        String str2;
        String str3;
        String str4;
        String optString2;
        String str5;
        String optString3;
        String str6;
        Object m9842constructorimpl;
        BackendMessageMatcher backendMessageMatcher;
        JSONObject optJSONObject = jSONObject.optJSONObject("match");
        if (optJSONObject != null || (optJSONObject = jSONObject.optJSONObject("matcher")) != null) {
            jSONObject = optJSONObject;
        }
        if (jSONObject.has("backendId")) {
            valueOf = Integer.valueOf(jSONObject.getInt("backendId"));
        } else if (jSONObject.has("frontendId")) {
            valueOf = Integer.valueOf(jSONObject.getInt("frontendId"));
        } else {
            num = null;
            optString = jSONObject.optString("backendName");
            if (StringsKt.isBlank(optString)) {
                optString = jSONObject.optString("frontendName");
            }
            str2 = optString;
            if (StringsKt.isBlank(str2)) {
                str2 = jSONObject.optString("backend");
            }
            str3 = str2;
            if (StringsKt.isBlank(str3)) {
                str3 = jSONObject.optString("frontend");
            }
            str4 = str3;
            if (StringsKt.isBlank(str4)) {
                str4 = null;
            }
            String str7 = str4;
            Integer valueOf2 = !jSONObject.has("subId") ? Integer.valueOf(jSONObject.getInt("subId")) : null;
            String extractRawMessage = !jSONObject.has("message") ? extractRawMessage(jSONObject, "message") : null;
            optString2 = jSONObject.optString("messageContains");
            if (StringsKt.isBlank(optString2)) {
                optString2 = jSONObject.optString("contains");
            }
            str5 = optString2;
            if (StringsKt.isBlank(str5)) {
                str5 = null;
            }
            String str8 = str5;
            optString3 = jSONObject.optString("messageRegex");
            if (StringsKt.isBlank(optString3)) {
                optString3 = jSONObject.optString("regex");
            }
            String str9 = optString3;
            str6 = StringsKt.isBlank(str9) ? null : str9;
            boolean optBoolean = jSONObject.optBoolean("ignoreCase", false);
            boolean optBoolean2 = jSONObject.optBoolean("matchAny", jSONObject.optBoolean("any", false));
            if (str6 != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    m9842constructorimpl = Result.m9842constructorimpl(new Regex(str6, optBoolean ? SetsKt.setOf(RegexOption.IGNORE_CASE) : SetsKt.emptySet()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m9842constructorimpl = Result.m9842constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m9845exceptionOrNullimpl = Result.m9845exceptionOrNullimpl(m9842constructorimpl);
                if (m9845exceptionOrNullimpl == null) {
                    Regex regex = (Regex) m9842constructorimpl;
                } else {
                    int i2 = i + 1;
                    String message = m9845exceptionOrNullimpl.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    throw new IllegalArgumentException(str + " #" + i2 + " contains invalid messageRegex '" + str6 + "': " + message);
                }
            }
            backendMessageMatcher = new BackendMessageMatcher(num, str7, valueOf2, extractRawMessage, str8, str6, optBoolean, optBoolean2);
            if (!backendMessageMatcher.getMatchAny() || backendMessageMatcher.getHasCriteria()) {
                return backendMessageMatcher;
            }
            throw new IllegalArgumentException(str + " #" + (i + 1) + " must contain at least one matcher field: 'backendId'/'backendName', 'subId', 'message', 'messageContains', 'messageRegex' or explicit 'matchAny': true");
        }
        num = valueOf;
        optString = jSONObject.optString("backendName");
        if (StringsKt.isBlank(optString)) {
        }
        str2 = optString;
        if (StringsKt.isBlank(str2)) {
        }
        str3 = str2;
        if (StringsKt.isBlank(str3)) {
        }
        str4 = str3;
        if (StringsKt.isBlank(str4)) {
        }
        String str72 = str4;
        if (!jSONObject.has("subId")) {
        }
        if (!jSONObject.has("message")) {
        }
        optString2 = jSONObject.optString("messageContains");
        if (StringsKt.isBlank(optString2)) {
        }
        str5 = optString2;
        if (StringsKt.isBlank(str5)) {
        }
        String str82 = str5;
        optString3 = jSONObject.optString("messageRegex");
        if (StringsKt.isBlank(optString3)) {
        }
        String str92 = optString3;
        str6 = StringsKt.isBlank(str92) ? null : str92;
        boolean optBoolean3 = jSONObject.optBoolean("ignoreCase", false);
        boolean optBoolean22 = jSONObject.optBoolean("matchAny", jSONObject.optBoolean("any", false));
        if (str6 != null) {
        }
        backendMessageMatcher = new BackendMessageMatcher(num, str72, valueOf2, extractRawMessage, str82, str6, optBoolean3, optBoolean22);
        if (backendMessageMatcher.getMatchAny()) {
        }
        return backendMessageMatcher;
    }

    private final String extractRawMessage(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return "";
        }
        Object obj = jSONObject.get(str);
        return obj instanceof String ? (String) obj : obj.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r2.equals("log") != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2.equals("validator") != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r2.equals("validate") != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
        return com.miami.game.core.settings.game_test.BackendReplayTarget.VALIDATOR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BackendReplayTarget optReplayTarget(JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(TypedValues.AttributesType.S_TARGET);
        if (StringsKt.isBlank(optString)) {
            optString = "UI";
        }
        String str = optString;
        Intrinsics.checkNotNull(str);
        String normalizeAction = normalizeAction(str);
        switch (normalizeAction.hashCode()) {
            case -1421272810:
                break;
            case -1109783726:
                break;
            case 3732:
                if (normalizeAction.equals("ui")) {
                    return BackendReplayTarget.UI;
                }
                throw new IllegalArgumentException("Step #" + (i + 1) + " contains unsupported target '" + str + "'");
            case 107332:
                break;
            case 3029889:
                if (normalizeAction.equals("both")) {
                    return BackendReplayTarget.BOTH;
                }
                throw new IllegalArgumentException("Step #" + (i + 1) + " contains unsupported target '" + str + "'");
            default:
                throw new IllegalArgumentException("Step #" + (i + 1) + " contains unsupported target '" + str + "'");
        }
    }

    private final String requireString(JSONObject jSONObject, String str, int i) {
        String optString = jSONObject.optString(str);
        if (StringsKt.isBlank(optString)) {
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain a non-empty '" + str + "'");
        }
        Intrinsics.checkNotNullExpressionValue(optString, "ifBlank(...)");
        return optString;
    }

    private final int requireInt(JSONObject jSONObject, String str, int i) {
        if (!jSONObject.has(str)) {
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain '" + str + "'");
        }
        return jSONObject.getInt(str);
    }

    private final int requirePositiveInt(JSONObject jSONObject, String str, int i) {
        int requireInt = requireInt(jSONObject, str, i);
        if (requireInt > 0) {
            return requireInt;
        }
        throw new IllegalArgumentException("Step #" + (i + 1) + " must contain a positive '" + str + "'");
    }

    private final long requireNonNegativeLong(JSONObject jSONObject, String str, int i) {
        if (!jSONObject.has(str)) {
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain '" + str + "'");
        }
        long j = jSONObject.getLong(str);
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Step #" + (i + 1) + " must contain a non-negative '" + str + "'");
    }

    private final double requirePercent(JSONObject jSONObject, String str, int i) {
        if (!jSONObject.has(str)) {
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain '" + str + "'");
        }
        double d = jSONObject.getDouble(str);
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d > 100.0d) {
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain '" + str + "' in range 0..100");
        }
        return d;
    }

    private final long optNonNegativeLong(JSONObject jSONObject, String str, long j, int i) {
        if (jSONObject.has(str)) {
            long j2 = jSONObject.getLong(str);
            if (j2 >= 0) {
                return j2;
            }
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain a non-negative '" + str + "'");
        }
        return j;
    }

    private final long optPositiveLong(JSONObject jSONObject, String str, long j, int i) {
        if (jSONObject.has(str)) {
            long j2 = jSONObject.getLong(str);
            if (j2 > 0) {
                return j2;
            }
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain a positive '" + str + "'");
        }
        return j;
    }

    private final Long optTimeoutMs(JSONObject jSONObject, int i) {
        if (!jSONObject.has("timeoutMs")) {
            return 10000L;
        }
        long j = jSONObject.getLong("timeoutMs");
        if (j < 0) {
            throw new IllegalArgumentException("Step #" + (i + 1) + " must contain a non-negative 'timeoutMs'");
        }
        Long valueOf = Long.valueOf(j);
        if (valueOf.longValue() > 0) {
            return valueOf;
        }
        return null;
    }
}
