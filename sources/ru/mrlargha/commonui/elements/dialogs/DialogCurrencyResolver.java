package ru.mrlargha.commonui.elements.dialogs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
/* compiled from: DialogCurrencyResolver.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u0016\u0010\u001c\u001a\u00020\u000b*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogCurrencyResolver;", "", "<init>", "()V", "specs", "", "Lru/mrlargha/commonui/elements/dialogs/DialogCurrencySpec;", "specsById", "", "", "resolve", "Lru/mrlargha/commonui/elements/dialogs/DialogCurrencyPresentation;", "explicitCurrency", "", "header", TtmlNode.TAG_BODY, "hint", "isPlaceholderCompatible", "", "placeholder", FirebaseAnalytics.Param.CURRENCY, "resolveExplicit", "value", "findInText", "text", "currencyAliasRegex", "Lkotlin/text/Regex;", "alias", "toPresentation", "displayedCode", "ARIZONA_ID", "BITCOIN_ID", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogCurrencyResolver {
    private static final int ARIZONA_ID = 0;
    private static final int BITCOIN_ID = 1;
    public static final DialogCurrencyResolver INSTANCE = new DialogCurrencyResolver();
    private static final List<DialogCurrencySpec> specs;
    private static final Map<Integer, DialogCurrencySpec> specsById;

    private DialogCurrencyResolver() {
    }

    static {
        List<DialogCurrencySpec> listOf = CollectionsKt.listOf((Object[]) new DialogCurrencySpec[]{new DialogCurrencySpec(0, "ARIZONA", R.drawable.currency_ic_arizona, SetsKt.setOf((Object[]) new String[]{"ARIZONA", "AARRP", "EURO", "EUR"})), new DialogCurrencySpec(1, "BTC", R.drawable.currency_ic_btc, SetsKt.setOf((Object[]) new String[]{"BTC", "BITCOIN"})), new DialogCurrencySpec(2, "ASC", R.drawable.cuurency_ic_asc, SetsKt.setOf("ASC")), new DialogCurrencySpec(3, "VC", R.drawable.currency_ic_vc, SetsKt.setOf((Object[]) new String[]{"VC COIN", "VC"})), new DialogCurrencySpec(4, "S&P 500", R.drawable.bank_currency_ic_sp_500, SetsKt.setOf((Object[]) new String[]{"S&P 500", "S&P500", "SP500", "SPX"})), new DialogCurrencySpec(5, "AAPL", R.drawable.bank_currency_ic_apple, SetsKt.setOf((Object[]) new String[]{"AAPL", "APPLE"})), new DialogCurrencySpec(6, "TSLA", R.drawable.bank_currency_ic_tesla, SetsKt.setOf((Object[]) new String[]{"TSLA", "TESLA"})), new DialogCurrencySpec(7, "VOW3", R.drawable.bank_currency_ic_volkswagen, SetsKt.setOf((Object[]) new String[]{"VOLKSWAGEN ST", "VOLKSWAGEN", "VOW3", "VOW"})), new DialogCurrencySpec(8, "AMZN", R.drawable.bank_currency_ic_amazon, SetsKt.setOf((Object[]) new String[]{"AMZN", "AMAZON"})), new DialogCurrencySpec(9, "GOOGL", R.drawable.bank_currency_ic_alphabet, SetsKt.setOf((Object[]) new String[]{"GOOGL", "GOOG", "ALPHABET"})), new DialogCurrencySpec(10, "BMW", R.drawable.bank_currency_ic_bmw, SetsKt.setOf((Object[]) new String[]{"OTCMKTS: (BMW)", "BMW"})), new DialogCurrencySpec(11, "MBG", R.drawable.bank_currency_ic_mercedes_benz, SetsKt.setOf((Object[]) new String[]{"MERCEDES-BENZ", "MERCEDES BENZ", "MERCEDES", "MBG"})), new DialogCurrencySpec(12, "NVDA", R.drawable.bank_currency_ic_nvidia, SetsKt.setOf((Object[]) new String[]{"NVDA", "NVIDIA"})), new DialogCurrencySpec(13, "TM", R.drawable.bank_currency_ic_toyota, SetsKt.setOf((Object[]) new String[]{"TOYOTA", "TM"})), new DialogCurrencySpec(14, "SPACEX", R.drawable.bank_currency_ic_spacex, SetsKt.setOf((Object[]) new String[]{"SPACE X", "SPACEX"})), new DialogCurrencySpec(15, "MSFT", R.drawable.bank_currency_ic_microsoft, SetsKt.setOf((Object[]) new String[]{"MSFT", "MICROSOFT"}))});
        specs = listOf;
        List<DialogCurrencySpec> list = listOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((DialogCurrencySpec) obj).getId()), obj);
        }
        specsById = linkedHashMap;
    }

    public final DialogCurrencyPresentation resolve(String explicitCurrency, String header, String body, String hint) {
        Intrinsics.checkNotNullParameter(explicitCurrency, "explicitCurrency");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(hint, "hint");
        DialogCurrencyPresentation findInText = findInText(header);
        DialogCurrencyPresentation findInText2 = findInText(body);
        DialogCurrencyPresentation resolveExplicit = resolveExplicit(explicitCurrency);
        if (resolveExplicit == null) {
            if (findInText == null) {
                if (findInText2 == null) {
                    DialogCurrencyPresentation findInText3 = findInText(hint);
                    return findInText3 == null ? toPresentation$default(this, (DialogCurrencySpec) MapsKt.getValue(specsById, 1), null, 1, null) : findInText3;
                }
            }
            return findInText;
        } else if (resolveExplicit.getId() == null) {
            if (findInText == null) {
                return findInText2 == null ? resolveExplicit : findInText2;
            }
            return findInText;
        } else {
            if (findInText != null) {
                Integer id = findInText.getId();
                int intValue = resolveExplicit.getId().intValue();
                if (id != null && id.intValue() == intValue) {
                    return findInText;
                }
            }
            if (findInText2 != null) {
                Integer id2 = findInText2.getId();
                int intValue2 = resolveExplicit.getId().intValue();
                if (id2 != null && id2.intValue() == intValue2) {
                    return findInText2;
                }
            }
            return resolveExplicit;
        }
    }

    public final boolean isPlaceholderCompatible(String placeholder, DialogCurrencyPresentation currency) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(currency, "currency");
        DialogCurrencyPresentation findInText = findInText(placeholder);
        if (findInText == null) {
            return true;
        }
        return Intrinsics.areEqual(findInText.getId(), currency.getId());
    }

    private final DialogCurrencyPresentation resolveExplicit(String str) {
        Object obj;
        DialogCurrencySpec dialogCurrencySpec;
        String obj2 = StringsKt.trim((CharSequence) str).toString();
        if (obj2.length() == 0) {
            return null;
        }
        Integer intOrNull = StringsKt.toIntOrNull(obj2);
        if (intOrNull != null && (dialogCurrencySpec = specsById.get(Integer.valueOf(intOrNull.intValue()))) != null) {
            return toPresentation$default(INSTANCE, dialogCurrencySpec, null, 1, null);
        }
        Iterator<T> it = specs.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Set<String> aliases = ((DialogCurrencySpec) obj).getAliases();
            if (!(aliases instanceof Collection) || !aliases.isEmpty()) {
                for (String str2 : aliases) {
                    if (StringsKt.equals(str2, obj2, true)) {
                        break loop0;
                    }
                }
                continue;
            }
        }
        DialogCurrencySpec dialogCurrencySpec2 = (DialogCurrencySpec) obj;
        if (dialogCurrencySpec2 != null) {
            return toPresentation$default(this, dialogCurrencySpec2, null, 1, null);
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = obj2.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return new DialogCurrencyPresentation(null, upperCase, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final DialogCurrencyPresentation findInText(String str) {
        DialogCurrencyPresentation dialogCurrencyPresentation;
        String upperCase;
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            return null;
        }
        for (DialogCurrencySpec dialogCurrencySpec : specs) {
            Iterator it = CollectionsKt.sortedWith(dialogCurrencySpec.getAliases(), new Comparator() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogCurrencyResolver$findInText$lambda$0$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((String) t2).length()), Integer.valueOf(((String) t).length()));
                }
            }).iterator();
            while (true) {
                if (!it.hasNext()) {
                    dialogCurrencyPresentation = null;
                    continue;
                    break;
                }
                DialogCurrencyResolver dialogCurrencyResolver = INSTANCE;
                MatchResult find$default = Regex.find$default(dialogCurrencyResolver.currencyAliasRegex((String) it.next()), str2, 0, 2, null);
                if (find$default != null) {
                    if (dialogCurrencySpec.getId() == 0) {
                        upperCase = dialogCurrencySpec.getCode();
                    } else {
                        String value = find$default.getValue();
                        Locale ROOT = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                        upperCase = value.toUpperCase(ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    }
                    dialogCurrencyPresentation = dialogCurrencyResolver.toPresentation(dialogCurrencySpec, upperCase);
                    continue;
                } else {
                    dialogCurrencyPresentation = null;
                    continue;
                }
                if (dialogCurrencyPresentation != null) {
                    break;
                }
            }
            if (dialogCurrencyPresentation != null) {
                return dialogCurrencyPresentation;
            }
        }
        return null;
    }

    private final Regex currencyAliasRegex(String str) {
        return new Regex("(?<![\\p{L}\\p{N}])" + Regex.Companion.escape(str) + "(?![\\p{L}\\p{N}])", RegexOption.IGNORE_CASE);
    }

    static /* synthetic */ DialogCurrencyPresentation toPresentation$default(DialogCurrencyResolver dialogCurrencyResolver, DialogCurrencySpec dialogCurrencySpec, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dialogCurrencySpec.getCode();
        }
        return dialogCurrencyResolver.toPresentation(dialogCurrencySpec, str);
    }

    private final DialogCurrencyPresentation toPresentation(DialogCurrencySpec dialogCurrencySpec, String str) {
        return new DialogCurrencyPresentation(Integer.valueOf(dialogCurrencySpec.getId()), str, Integer.valueOf(dialogCurrencySpec.getIconResId()));
    }
}
