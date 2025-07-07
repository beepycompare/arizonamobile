package com.arkivanov.essenty.statekeeper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"essentyJson", "Lkotlinx/serialization/json/Json;", "getEssentyJson", "()Lkotlinx/serialization/json/Json;", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
    private static final Json essentyJson = JsonKt.Json$default(null, new Function1() { // from class: com.arkivanov.essenty.statekeeper.UtilsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit essentyJson$lambda$0;
            essentyJson$lambda$0 = UtilsKt.essentyJson$lambda$0((JsonBuilder) obj);
            return essentyJson$lambda$0;
        }
    }, 1, null);

    public static final Json getEssentyJson() {
        return essentyJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit essentyJson$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setAllowStructuredMapKeys(true);
        return Unit.INSTANCE;
    }
}
