package ru.mrlargha.arizona.rating;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
/* compiled from: RatingApi.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0011¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizona/rating/RatingApi;", "", "getCarsList", "", "Lru/mrlargha/arizona/rating/RatingItem;", "page", "", "sortDesc", "", "qualityType", FirebaseAnalytics.Event.SEARCH, "", "(IZILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccsList", "getQualityTypesCars", "Lru/mrlargha/arizona/rating/QualityType;", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQualityTypesAccs", "getQualityBonusesCars", "Lru/mrlargha/arizona/rating/BonusType;", "getQualityBonusesAccs", "item-rating_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface RatingApi {
    @GET("client/accessories/getRatingList")
    Object getAccsList(@Query("page") int i, @Query("sortDesc") boolean z, @Query("qualityType") int i2, @Query("search") String str, Continuation<? super List<RatingItem>> continuation);

    @GET("client/vehicles/getRatingList")
    Object getCarsList(@Query("page") int i, @Query("sortDesc") boolean z, @Query("qualityType") int i2, @Query("search") String str, Continuation<? super List<RatingItem>> continuation);

    @GET("client/json/table/get")
    Object getQualityBonusesAccs(@Query("key") String str, Continuation<? super List<BonusType>> continuation);

    @GET("client/json/table/get")
    Object getQualityBonusesCars(@Query("key") String str, Continuation<? super List<BonusType>> continuation);

    @GET("client/json/table/get")
    Object getQualityTypesAccs(@Query("key") String str, Continuation<? super List<QualityType>> continuation);

    @GET("client/json/table/get")
    Object getQualityTypesCars(@Query("key") String str, Continuation<? super List<QualityType>> continuation);

    /* compiled from: RatingApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getCarsList$default(RatingApi ratingApi, int i, boolean z, int i2, String str, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                z = true;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            if ((i3 & 8) != 0) {
                str = "";
            }
            return ratingApi.getCarsList(i, z, i2, str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCarsList");
    }

    static /* synthetic */ Object getAccsList$default(RatingApi ratingApi, int i, boolean z, int i2, String str, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                z = true;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            if ((i3 & 8) != 0) {
                str = "";
            }
            return ratingApi.getAccsList(i, z, i2, str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAccsList");
    }

    static /* synthetic */ Object getQualityTypesCars$default(RatingApi ratingApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "vehicle_quality_types";
            }
            return ratingApi.getQualityTypesCars(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQualityTypesCars");
    }

    static /* synthetic */ Object getQualityTypesAccs$default(RatingApi ratingApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "accessory_quality_types";
            }
            return ratingApi.getQualityTypesAccs(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQualityTypesAccs");
    }

    static /* synthetic */ Object getQualityBonusesCars$default(RatingApi ratingApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "vehicle_quality_bonuses";
            }
            return ratingApi.getQualityBonusesCars(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQualityBonusesCars");
    }

    static /* synthetic */ Object getQualityBonusesAccs$default(RatingApi ratingApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "accessory_quality_bonuses";
            }
            return ratingApi.getQualityBonusesAccs(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQualityBonusesAccs");
    }
}
