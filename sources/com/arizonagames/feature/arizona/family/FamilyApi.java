package com.arizonagames.feature.arizona.family;

import com.arizona.launcher.model.settings.SettingsConstants;
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
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0001\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0016\b\u0003\u0010\n\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\nH§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b(\r¢\u0006\u0002\u0010\u000bJ4\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0001\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tH§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010\u0010Jj\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0001\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0016\b\u0003\u0010\n\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n2\u0016\b\u0001\u0010\u0013\u001a\u00020\u0014:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015H§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b(\r¢\u0006\u0002\u0010\u0016J:\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0016\b\u0003\u0010\n\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\nH§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u0010Jj\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0016\b\u0001\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0016\b\u0003\u0010\n\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n2\u0016\b\u0001\u0010\u0013\u001a\u00020\u0014:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015H§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b(\u001c¢\u0006\u0002\u0010\u0016JR\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0016\b\u0001\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0016\b\u0003\u0010\n\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\nH§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b(\u001c¢\u0006\u0002\u0010\u000bJ\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0003H§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b(!¢\u0006\u0002\u0010 J:\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00032\u0016\b\u0001\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tH§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b($¢\u0006\u0002\u0010\u0010J\"\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003H§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b('¢\u0006\u0002\u0010 J:\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\u0016\b\u0001\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tH§@b\f\b\f\u0012\b\b\b\u0012\u0004\b\b(*¢\u0006\u0002\u0010\u0010¨\u0006+À\u0006\u0003"}, d2 = {"Lcom/arizonagames/feature/arizona/family/FamilyApi;", "", "getMembers", "", "Lcom/arizonagames/feature/arizona/family/data/MemberItem;", "familyId", "", "Lretrofit2/http/Query;", "value", "family_id", "page", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/GET;", "client/family/getMembers", "getMembersCount", "Lcom/arizonagames/feature/arizona/family/data/FamilyMembersCount;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "client/family/getMembersCount", "getMembersName", "name", "", SettingsConstants.NICKNAME, "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRating", "Lcom/arizonagames/feature/arizona/family/data/RatingItem;", "client/family/getRating", "getCharterName", "Lcom/arizonagames/feature/arizona/family/data/CharterItem;", "client/family/getPrivateFractionMembers", "getCharter", "getGangZone", "Lcom/arizonagames/feature/arizona/family/data/GangZoneItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "client/family/getGangzones", "getCaptures", "Lcom/arizonagames/feature/arizona/family/data/CapturesItem;", "client/family/getCaptures", "getGangZonesTop", "Lcom/arizonagames/feature/arizona/family/data/GangZonesTopItem;", "client/family/getGangZonesTop", "getGangZonesList", "Lcom/arizonagames/feature/arizona/family/data/GangZonesListItem;", "client/family/getGangZonesList", "family"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
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
