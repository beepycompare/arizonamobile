package ru.mrlargha.commonui.elements.dialogs;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final /* synthetic */ class DialogBankTaxPaymentKt$taxListValue$source$1 extends FunctionReferenceImpl implements Function1<String, JsonElement> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogBankTaxPaymentKt$taxListValue$source$1(Object obj) {
        super(1, obj, JsonObject.class, "get", "get(Ljava/lang/String;)Lcom/google/gson/JsonElement;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final JsonElement invoke(String str) {
        return ((JsonObject) this.receiver).get(str);
    }
}
