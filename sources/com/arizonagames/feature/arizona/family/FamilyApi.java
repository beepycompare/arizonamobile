package com.arizonagames.feature.arizona.family;

import com.arizonagames.feature.arizona.family.data.CapturesItem;
import com.arizonagames.feature.arizona.family.data.CharterItem;
import com.arizonagames.feature.arizona.family.data.FamilyMembersCount;
import com.arizonagames.feature.arizona.family.data.GangZoneItem;
import com.arizonagames.feature.arizona.family.data.GangZonesListItem;
import com.arizonagames.feature.arizona.family.data.GangZonesTopItem;
import com.arizonagames.feature.arizona.family.data.MemberItem;
import com.arizonagames.feature.arizona.family.data.RatingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
/* compiled from: FamilyApi.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u000bJ2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u000bJ2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\bJ\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u000b¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/arizonagames/feature/arizona/family/FamilyApi;", "", "getMembers", "", "Lcom/arizonagames/feature/arizona/family/data/MemberItem;", "familyId", "", "page", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMembersCount", "Lcom/arizonagames/feature/arizona/family/data/FamilyMembersCount;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMembersName", "name", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRating", "Lcom/arizonagames/feature/arizona/family/data/RatingItem;", "getCharterName", "Lcom/arizonagames/feature/arizona/family/data/CharterItem;", "getCharter", "getGangZone", "Lcom/arizonagames/feature/arizona/family/data/GangZoneItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaptures", "Lcom/arizonagames/feature/arizona/family/data/CapturesItem;", "getGangZonesTop", "Lcom/arizonagames/feature/arizona/family/data/GangZonesTopItem;", "getGangZonesList", "Lcom/arizonagames/feature/arizona/family/data/GangZonesListItem;", "family"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FamilyApi {
    @GET("client/family/getCaptures")
    Object getCaptures(@Query("family_id") int i, Continuation<? super List<CapturesItem>> continuation);

    @GET("client/family/getPrivateFractionMembers")
    Object getCharter(@Query("family_id") int i, @Query("page") int i2, Continuation<? super List<CharterItem>> continuation);

    @GET("client/family/getPrivateFractionMembers")
    Object getCharterName(@Query("family_id") int i, @Query("page") int i2, @Query("nickname") String str, Continuation<? super List<CharterItem>> continuation);

    @GET("client/family/getGangzones")
    Object getGangZone(Continuation<? super List<GangZoneItem>> continuation);

    @GET("client/family/getGangZonesList")
    Object getGangZonesList(@Query("family_id") int i, Continuation<? super List<GangZonesListItem>> continuation);

    @GET("client/family/getGangZonesTop")
    Object getGangZonesTop(Continuation<? super List<GangZonesTopItem>> continuation);

    @GET("client/family/getMembers")
    Object getMembers(@Query("family_id") int i, @Query("page") int i2, Continuation<? super List<MemberItem>> continuation);

    @GET("client/family/getMembersCount")
    Object getMembersCount(@Query("family_id") int i, Continuation<? super FamilyMembersCount> continuation);

    @GET("client/family/getMembers")
    Object getMembersName(@Query("family_id") int i, @Query("page") int i2, @Query("nickname") String str, Continuation<? super List<MemberItem>> continuation);

    @GET("client/family/getRating")
    Object getRating(@Query("page") int i, Continuation<? super List<RatingItem>> continuation);

    /* compiled from: FamilyApi.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getMembers$default(FamilyApi familyApi, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 1;
            }
            return familyApi.getMembers(i, i2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMembers");
    }

    static /* synthetic */ Object getMembersName$default(FamilyApi familyApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 1;
            }
            return familyApi.getMembersName(i, i2, str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMembersName");
    }

    static /* synthetic */ Object getRating$default(FamilyApi familyApi, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 1;
            }
            return familyApi.getRating(i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRating");
    }

    static /* synthetic */ Object getCharterName$default(FamilyApi familyApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 1;
            }
            return familyApi.getCharterName(i, i2, str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCharterName");
    }

    static /* synthetic */ Object getCharter$default(FamilyApi familyApi, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 1;
            }
            return familyApi.getCharter(i, i2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCharter");
    }
}
