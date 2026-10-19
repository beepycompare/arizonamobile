package com.arizona.game;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModsOverlayController.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class ModsOverlayController$listener$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ModsOverlayController$listener$1(Object obj) {
        super(1, obj, ModsOverlayController.class, "render", "render(Lorg/json/JSONObject;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
        invoke2(jSONObject);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((ModsOverlayController) this.receiver).render(p0);
    }
}
