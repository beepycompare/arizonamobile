package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.elements.donate.domain.models.DonatePayPassLevelModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonatePayPassLevelRewardModel;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u001a \u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u000e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a\f\u0010\u0013\u001a\u00020\u0003*\u00020\u0014H\u0002\u001a\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u001dH\u0002\u001a\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u0007*\u00020\tH\u0002\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\u001c*\u00020 H\u0002\u001a\u000e\u0010!\u001a\u00020\u0001*\u0004\u0018\u00010\"H\u0002\u001a\u0013\u0010#\u001a\u00020\u0010*\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010$\u001a\f\u0010%\u001a\u00020&*\u00020&H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"PAYPASS_ITEM_IMAGE_PATH", "", "parseDonatePayPassDynamicState", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassDynamicState;", "json", "mapPayPassCatalog", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassLevel;", "models", "Lru/mrlargha/commonui/elements/donate/domain/models/DonatePayPassLevelModel;", "resolvePayPassState", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassState;", "catalog", "dynamic", "formatPayPassMoney", "value", "", "resolvePayPassBattlePassImageUrl", "img", "toDynamic", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassStateDto;", "toLegacyReward", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassRewardDto;", "seenIds", "", "", "toDomain", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrize;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrizeDto;", "toLevel", "toPrize", "Lru/mrlargha/commonui/elements/donate/domain/models/DonatePayPassLevelRewardModel;", "payPassImgToken", "Lcom/google/gson/JsonElement;", "orZeroNonNegative", "(Ljava/lang/Double;)D", "saturatingSecondsToMillis", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassStateKt {
    private static final String PAYPASS_ITEM_IMAGE_PATH = "systems/battlepass/items";

    /* JADX INFO: Access modifiers changed from: private */
    public static final long saturatingSecondsToMillis(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j > 9223372036854775L) {
            return Long.MAX_VALUE;
        }
        return j * 1000;
    }

    public static final DonatePayPassDynamicState parseDonatePayPassDynamicState(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        String obj = StringsKt.trim((CharSequence) json).toString();
        if (obj.length() != 0 && StringsKt.startsWith$default(obj, "{", false, 2, (Object) null)) {
            try {
                DonatePayPassStateDto donatePayPassStateDto = (DonatePayPassStateDto) MapperKt.getGson().fromJson(obj, (Class<Object>) DonatePayPassStateDto.class);
                if (donatePayPassStateDto == null) {
                    return null;
                }
                return toDynamic(donatePayPassStateDto);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static final List<DonatePayPassLevel> mapPayPassCatalog(List<DonatePayPassLevelModel> models) {
        Intrinsics.checkNotNullParameter(models, "models");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (DonatePayPassLevelModel donatePayPassLevelModel : models) {
            DonatePayPassLevel level = toLevel(donatePayPassLevelModel);
            if (level != null) {
                arrayList.add(level);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(Integer.valueOf(((DonatePayPassLevel) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassStateKt$mapPayPassCatalog$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((DonatePayPassLevel) t).getId()), Integer.valueOf(((DonatePayPassLevel) t2).getId()));
            }
        });
    }

    public static final DonatePayPassState resolvePayPassState(List<DonatePayPassLevel> catalog, DonatePayPassDynamicState donatePayPassDynamicState) {
        ArrayList legacyRewards;
        Intrinsics.checkNotNullParameter(catalog, "catalog");
        if (donatePayPassDynamicState == null) {
            return null;
        }
        if (!catalog.isEmpty()) {
            List<DonatePayPassLevel> list = catalog;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DonatePayPassLevel donatePayPassLevel : list) {
                arrayList.add(new DonatePayPassReward(donatePayPassLevel.getId(), donatePayPassLevel.getId(), donatePayPassDynamicState.getStatuses().get(Integer.valueOf(donatePayPassLevel.getId())), donatePayPassLevel.getPrizes(), Integer.valueOf(donatePayPassLevel.getPrice())));
            }
            legacyRewards = arrayList;
        } else {
            legacyRewards = donatePayPassDynamicState.getLegacyRewards();
        }
        return new DonatePayPassState(donatePayPassDynamicState.getTotalMoney(), donatePayPassDynamicState.getMaxMoney(), donatePayPassDynamicState.getUnixEndSeason(), donatePayPassDynamicState.getCurrentLevel(), legacyRewards);
    }

    public static final String formatPayPassMoney(double d) {
        int i = (Math.abs(d) > Double.MAX_VALUE ? 1 : (Math.abs(d) == Double.MAX_VALUE ? 0 : -1));
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (i <= 0) {
            d2 = RangesKt.coerceAtLeast(d, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        decimalFormatSymbols.setGroupingSeparator(' ');
        decimalFormatSymbols.setDecimalSeparator('.');
        String format = new DecimalFormat(Math.abs(d2 % 1.0d) >= 0.005d ? "#,##0.##" : "#,##0", decimalFormatSymbols).format(d2);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String resolvePayPassBattlePassImageUrl(String img) {
        Intrinsics.checkNotNullParameter(img, "img");
        String obj = StringsKt.trim((CharSequence) img).toString();
        String str = obj;
        if (str.length() == 0) {
            return "";
        }
        if (StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "http://", false, 2, (Object) null)) {
            return obj;
        }
        if (!StringsKt.contains$default((CharSequence) str, '.', false, 2, (Object) null)) {
            obj = obj + ".webp";
        }
        return StringsKt.trimEnd(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null), '/') + "/systems/battlepass/items/" + StringsKt.trimStart(obj, '/');
    }

    private static final DonatePayPassDynamicState toDynamic(DonatePayPassStateDto donatePayPassStateDto) {
        ArrayList<Pair> arrayList;
        ArrayList arrayList2;
        if (donatePayPassStateDto.getPrizes() != null) {
            List<DonatePayPassStatusDto> prizes = donatePayPassStateDto.getPrizes();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(prizes, 10));
            for (DonatePayPassStatusDto donatePayPassStatusDto : prizes) {
                arrayList3.add(TuplesKt.to(donatePayPassStatusDto.getId(), donatePayPassStatusDto.getStatus()));
            }
            arrayList = arrayList3;
        } else {
            List<DonatePayPassRewardDto> rewards = donatePayPassStateDto.getRewards();
            if (rewards == null) {
                rewards = CollectionsKt.emptyList();
            }
            List<DonatePayPassRewardDto> list = rewards;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DonatePayPassRewardDto donatePayPassRewardDto : list) {
                Integer id = donatePayPassRewardDto.getId();
                if (id == null) {
                    id = donatePayPassRewardDto.getLevel();
                }
                arrayList4.add(TuplesKt.to(id, donatePayPassRewardDto.getStatus()));
            }
            arrayList = arrayList4;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            Integer num = (Integer) pair.component1();
            String str = (String) pair.component2();
            if (num != null && !linkedHashMap.containsKey(num)) {
                linkedHashMap.put(num, DonatePayPassTierStatus.Companion.fromWire(str));
            }
        }
        if (donatePayPassStateDto.getPrizes() != null) {
            arrayList2 = CollectionsKt.emptyList();
        } else {
            HashSet hashSet = new HashSet();
            List<DonatePayPassRewardDto> rewards2 = donatePayPassStateDto.getRewards();
            if (rewards2 == null) {
                rewards2 = CollectionsKt.emptyList();
            }
            ArrayList arrayList5 = new ArrayList();
            for (DonatePayPassRewardDto donatePayPassRewardDto2 : rewards2) {
                DonatePayPassReward legacyReward = toLegacyReward(donatePayPassRewardDto2, hashSet);
                if (legacyReward != null) {
                    arrayList5.add(legacyReward);
                }
            }
            arrayList2 = arrayList5;
        }
        List list2 = arrayList2;
        double orZeroNonNegative = orZeroNonNegative(donatePayPassStateDto.getTotalMoney());
        double orZeroNonNegative2 = orZeroNonNegative(donatePayPassStateDto.getMaxMoney());
        Long unixEndSeason = donatePayPassStateDto.getUnixEndSeason();
        long longValue = unixEndSeason != null ? unixEndSeason.longValue() : 0L;
        Integer currentLevel = donatePayPassStateDto.getCurrentLevel();
        return new DonatePayPassDynamicState(orZeroNonNegative, orZeroNonNegative2, longValue, currentLevel != null ? RangesKt.coerceAtLeast(currentLevel.intValue(), 0) : 0, linkedHashMap, list2);
    }

    private static final DonatePayPassReward toLegacyReward(DonatePayPassRewardDto donatePayPassRewardDto, Set<Integer> set) {
        Integer id = donatePayPassRewardDto.getId();
        if (id == null && (id = donatePayPassRewardDto.getLevel()) == null) {
            return null;
        }
        int intValue = id.intValue();
        if (set.add(Integer.valueOf(intValue))) {
            DonatePayPassTierStatus fromWire = DonatePayPassTierStatus.Companion.fromWire(donatePayPassRewardDto.getStatus());
            List<DonatePayPassPrizeDto> prizes = donatePayPassRewardDto.getPrizes();
            if (prizes == null) {
                prizes = CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (DonatePayPassPrizeDto donatePayPassPrizeDto : prizes) {
                DonatePayPassPrize domain = toDomain(donatePayPassPrizeDto);
                if (domain != null) {
                    arrayList.add(domain);
                }
            }
            return new DonatePayPassReward(intValue, intValue, fromWire, arrayList, null, 16, null);
        }
        return null;
    }

    private static final DonatePayPassPrize toDomain(DonatePayPassPrizeDto donatePayPassPrizeDto) {
        Long count = donatePayPassPrizeDto.getCount();
        long longValue = count != null ? count.longValue() : 0L;
        if (longValue < 0) {
            return null;
        }
        String image = donatePayPassPrizeDto.getImage();
        String str = image == null ? "" : image;
        String title = donatePayPassPrizeDto.getTitle();
        String str2 = title == null ? "" : title;
        String description = donatePayPassPrizeDto.getDescription();
        return new DonatePayPassPrize(str, longValue, str2, description == null ? "" : description, 0, false, 48, null);
    }

    private static final DonatePayPassLevel toLevel(DonatePayPassLevelModel donatePayPassLevelModel) {
        Integer id = donatePayPassLevelModel.getId();
        if (id != null) {
            int intValue = id.intValue();
            Integer price = donatePayPassLevelModel.getPrice();
            int coerceAtLeast = price != null ? RangesKt.coerceAtLeast(price.intValue(), 0) : 0;
            List<DonatePayPassLevelRewardModel> rewards = donatePayPassLevelModel.getRewards();
            if (rewards == null) {
                rewards = CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (DonatePayPassLevelRewardModel donatePayPassLevelRewardModel : rewards) {
                DonatePayPassPrize prize = toPrize(donatePayPassLevelRewardModel);
                if (prize != null) {
                    arrayList.add(prize);
                }
            }
            return new DonatePayPassLevel(intValue, coerceAtLeast, arrayList);
        }
        return null;
    }

    private static final DonatePayPassPrize toPrize(DonatePayPassLevelRewardModel donatePayPassLevelRewardModel) {
        Long value = donatePayPassLevelRewardModel.getValue();
        long longValue = value != null ? value.longValue() : 0L;
        if (longValue < 0) {
            return null;
        }
        List<String> description = donatePayPassLevelRewardModel.getDescription();
        if (description == null) {
            description = CollectionsKt.emptyList();
        }
        List<String> list = description;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(StringsKt.trim((CharSequence) str).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        return new DonatePayPassPrize(resolvePayPassBattlePassImageUrl(payPassImgToken(donatePayPassLevelRewardModel.getImg())), longValue, CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null), "", 0, false, 48, null);
    }

    private static final String payPassImgToken(JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull() || !jsonElement.isJsonPrimitive()) {
            return "";
        }
        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
        if (asJsonPrimitive.isString()) {
            String asString = asJsonPrimitive.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
            return StringsKt.trim((CharSequence) asString).toString();
        } else if (!asJsonPrimitive.isNumber()) {
            return "";
        } else {
            double asDouble = asJsonPrimitive.getAsDouble();
            long j = (long) asDouble;
            if (asDouble == j) {
                return String.valueOf(j);
            }
            String asString2 = asJsonPrimitive.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString2, "getAsString(...)");
            return asString2;
        }
    }

    private static final double orZeroNonNegative(Double d) {
        if (d != null) {
            double doubleValue = d.doubleValue();
            return Math.abs(doubleValue) <= Double.MAX_VALUE ? RangesKt.coerceAtLeast(doubleValue, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }
}
