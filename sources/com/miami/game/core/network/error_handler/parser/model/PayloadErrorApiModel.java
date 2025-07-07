package com.miami.game.core.network.error_handler.parser.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PayloadErrorApiModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003HÆ\u0003J+\u0010\f\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/miami/game/core/network/error_handler/parser/model/PayloadErrorApiModel;", "", "errors", "", "Lcom/miami/game/core/network/error_handler/parser/model/PayloadErrorTypeApiModel;", "", "", "<init>", "(Ljava/util/Map;)V", "getErrors", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayloadErrorApiModel {
    @SerializedName("errors")
    private final Map<PayloadErrorTypeApiModel, List<String>> errors;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayloadErrorApiModel copy$default(PayloadErrorApiModel payloadErrorApiModel, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = payloadErrorApiModel.errors;
        }
        return payloadErrorApiModel.copy(map);
    }

    public final Map<PayloadErrorTypeApiModel, List<String>> component1() {
        return this.errors;
    }

    public final PayloadErrorApiModel copy(Map<PayloadErrorTypeApiModel, ? extends List<String>> map) {
        return new PayloadErrorApiModel(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PayloadErrorApiModel) && Intrinsics.areEqual(this.errors, ((PayloadErrorApiModel) obj).errors);
    }

    public int hashCode() {
        Map<PayloadErrorTypeApiModel, List<String>> map = this.errors;
        if (map == null) {
            return 0;
        }
        return map.hashCode();
    }

    public String toString() {
        return "PayloadErrorApiModel(errors=" + this.errors + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PayloadErrorApiModel(Map<PayloadErrorTypeApiModel, ? extends List<String>> map) {
        this.errors = map;
    }

    public final Map<PayloadErrorTypeApiModel, List<String>> getErrors() {
        return this.errors;
    }
}
