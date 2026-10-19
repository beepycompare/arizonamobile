package ru.mrlargha.commonui.elements.inventory.domain.models;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: InventoryHoldAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryHoldAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Boolean;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Boolean;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryHoldAdapter extends TypeAdapter<Boolean> {
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, Boolean bool) {
        Intrinsics.checkNotNullParameter(out, "out");
        if (bool == null) {
            out.nullValue();
        } else {
            out.value(bool.booleanValue());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Boolean read(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        } else if (UtilsKt.isArizonaType() || reader.peek() != JsonToken.NUMBER) {
            return Boolean.valueOf(reader.nextBoolean());
        } else {
            return Boolean.valueOf(reader.nextInt() != 0);
        }
    }
}
