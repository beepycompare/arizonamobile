package ru.mrlargha.arizona.rating;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
/* compiled from: CertificateApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/arizona/rating/CertificateApi;", "", "getQualityTypesCars", "", "Lcom/arizonagames/feature/arizona/certificate/QualityType;", "key", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQualityTypesAccs", "getQualityBonusesCars", "Lcom/arizonagames/feature/arizona/certificate/BonusType;", "getQualityBonusesAccs", "certificate_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CertificateApi {
    @GET("client/json/table/get")
    Object getQualityBonusesAccs(@Query("key") String str, Continuation<? super List<com.arizonagames.feature.arizona.certificate.BonusType>> continuation);

    @GET("client/json/table/get")
    Object getQualityBonusesCars(@Query("key") String str, Continuation<? super List<com.arizonagames.feature.arizona.certificate.BonusType>> continuation);

    @GET("client/json/table/get")
    Object getQualityTypesAccs(@Query("key") String str, Continuation<? super List<com.arizonagames.feature.arizona.certificate.QualityType>> continuation);

    @GET("client/json/table/get")
    Object getQualityTypesCars(@Query("key") String str, Continuation<? super List<com.arizonagames.feature.arizona.certificate.QualityType>> continuation);

    /* compiled from: CertificateApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getQualityTypesCars$default(CertificateApi certificateApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "vehicle_quality_types";
            }
            return certificateApi.getQualityTypesCars(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQualityTypesCars");
    }

    static /* synthetic */ Object getQualityTypesAccs$default(CertificateApi certificateApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "accessory_quality_types";
            }
            return certificateApi.getQualityTypesAccs(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQualityTypesAccs");
    }

    static /* synthetic */ Object getQualityBonusesCars$default(CertificateApi certificateApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "vehicle_quality_bonuses";
            }
            return certificateApi.getQualityBonusesCars(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQualityBonusesCars");
    }

    static /* synthetic */ Object getQualityBonusesAccs$default(CertificateApi certificateApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "accessory_quality_bonuses";
            }
            return certificateApi.getQualityBonusesAccs(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQualityBonusesAccs");
    }
}
