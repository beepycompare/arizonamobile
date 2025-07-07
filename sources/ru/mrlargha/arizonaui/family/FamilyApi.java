package ru.mrlargha.arizonaui.family;

import com.arizona.game.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import ru.mrlargha.arizonaui.family.data.CapturesItem;
import ru.mrlargha.arizonaui.family.data.CharterItem;
import ru.mrlargha.arizonaui.family.data.GangZoneItem;
import ru.mrlargha.arizonaui.family.data.GangZonesListItem;
import ru.mrlargha.arizonaui.family.data.GangZonesTopItem;
import ru.mrlargha.arizonaui.family.data.MemberItem;
import ru.mrlargha.arizonaui.family.data.RatingItem;
/* compiled from: FamilyApi.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\tH§@¢\u0006\u0002\u0010\fJP\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u000fJ<\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0012JP\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u000fJF\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\tH§@¢\u0006\u0002\u0010\fJ2\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0018J<\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0012J2\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0018J<\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0012¨\u0006\u001f"}, d2 = {"Lru/mrlargha/arizonaui/family/FamilyApi;", "", "getMembers", "", "Lru/mrlargha/arizonaui/family/data/MemberItem;", "token", "", "project", "id", "", "familyId", "page", "(Ljava/lang/String;Ljava/lang/String;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMembersName", "name", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRating", "Lru/mrlargha/arizonaui/family/data/RatingItem;", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCharterName", "Lru/mrlargha/arizonaui/family/data/CharterItem;", "getCharter", "getGangZone", "Lru/mrlargha/arizonaui/family/data/GangZoneItem;", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaptures", "Lru/mrlargha/arizonaui/family/data/CapturesItem;", "getGangZonesTop", "Lru/mrlargha/arizonaui/family/data/GangZonesTopItem;", "getGangZonesList", "Lru/mrlargha/arizonaui/family/data/GangZonesListItem;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FamilyApi {
    @GET("getCaptures")
    Object getCaptures(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("family_id") int i2, Continuation<? super List<CapturesItem>> continuation);

    @GET("getPrivateFractionMembers")
    Object getCharter(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("family_id") int i2, @Query("page") int i3, Continuation<? super List<CharterItem>> continuation);

    @GET("getPrivateFractionMembers")
    Object getCharterName(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("family_id") int i2, @Query("page") int i3, @Query("nickname") String str3, Continuation<? super List<CharterItem>> continuation);

    @GET("getGangzones")
    Object getGangZone(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, Continuation<? super List<GangZoneItem>> continuation);

    @GET("getGangZonesList")
    Object getGangZonesList(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("family_id") int i2, Continuation<? super List<GangZonesListItem>> continuation);

    @GET("getGangZonesTop")
    Object getGangZonesTop(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, Continuation<? super List<GangZonesTopItem>> continuation);

    @GET("getMembers")
    Object getMembers(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("family_id") int i2, @Query("page") int i3, Continuation<? super List<MemberItem>> continuation);

    @GET("getMembers")
    Object getMembersName(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("family_id") int i2, @Query("page") int i3, @Query("nickname") String str3, Continuation<? super List<MemberItem>> continuation);

    @GET("getRating")
    Object getRating(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("page") int i2, Continuation<? super List<RatingItem>> continuation);

    /* compiled from: FamilyApi.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getMembers$default(FamilyApi familyApi, String str, String str2, int i, int i2, int i3, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                String str3 = str2;
                if ((i4 & 4) != 0) {
                    i = 0;
                }
                int i5 = i;
                if ((i4 & 16) != 0) {
                    i3 = 1;
                }
                return familyApi.getMembers(str, str3, i5, i2, i3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMembers");
        }

        public static /* synthetic */ Object getMembersName$default(FamilyApi familyApi, String str, String str2, int i, int i2, int i3, String str3, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                String str4 = str2;
                if ((i4 & 4) != 0) {
                    i = 0;
                }
                int i5 = i;
                if ((i4 & 16) != 0) {
                    i3 = 1;
                }
                return familyApi.getMembersName(str, str4, i5, i2, i3, str3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMembersName");
        }

        public static /* synthetic */ Object getRating$default(FamilyApi familyApi, String str, String str2, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                String str3 = str2;
                if ((i3 & 8) != 0) {
                    i2 = 1;
                }
                return familyApi.getRating(str, str3, i, i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRating");
        }

        public static /* synthetic */ Object getCharterName$default(FamilyApi familyApi, String str, String str2, int i, int i2, int i3, String str3, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                String str4 = str2;
                if ((i4 & 16) != 0) {
                    i3 = 1;
                }
                return familyApi.getCharterName(str, str4, i, i2, i3, str3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCharterName");
        }

        public static /* synthetic */ Object getCharter$default(FamilyApi familyApi, String str, String str2, int i, int i2, int i3, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                String str3 = str2;
                if ((i4 & 16) != 0) {
                    i3 = 1;
                }
                return familyApi.getCharter(str, str3, i, i2, i3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCharter");
        }

        public static /* synthetic */ Object getGangZone$default(FamilyApi familyApi, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                return familyApi.getGangZone(str, str2, i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGangZone");
        }

        public static /* synthetic */ Object getCaptures$default(FamilyApi familyApi, String str, String str2, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                return familyApi.getCaptures(str, str2, i, i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCaptures");
        }

        public static /* synthetic */ Object getGangZonesTop$default(FamilyApi familyApi, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                return familyApi.getGangZonesTop(str, str2, i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGangZonesTop");
        }

        public static /* synthetic */ Object getGangZonesList$default(FamilyApi familyApi, String str, String str2, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = BuildConfig.FLAVOR;
                }
                return familyApi.getGangZonesList(str, str2, i, i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGangZonesList");
        }
    }
}
