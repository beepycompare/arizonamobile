package com.arizonagames.feature.arizona.family.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.family.R;
import com.arizonagames.feature.arizona.family.data.FamilySettingsData;
import com.arizonagames.feature.arizona.family.databinding.FamilySettingsItemBinding;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: SettingsAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/arizonagames/feature/arizona/family/adapters/SettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/family/adapters/SettingsItemViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "estate", "settingsData", "Lcom/arizonagames/feature/arizona/family/data/FamilySettingsData;", "onlineCount", "items", "", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "allianceName", "", "estateColor", "descColor", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setInfo", "haveEstate", "setAllianceTitle", "title", "family"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsAdapter extends RecyclerView.Adapter<SettingsItemViewHolder> {
    private String allianceName;
    private final int descColor;
    private int estate;
    private final int estateColor;
    private List<Integer> items;
    private final Function1<Integer, Unit> onClick;
    private int onlineCount;
    private FamilySettingsData settingsData;

    /* JADX WARN: Multi-variable type inference failed */
    public SettingsAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.settingsData = new FamilySettingsData(-1L, -1L, 0);
        this.onlineCount = 40;
        this.items = CollectionsKt.toMutableList(new IntRange(0, 18));
        this.allianceName = "Создать альянс";
        this.estateColor = Color.parseColor("#E0CA4C");
        this.descColor = Color.parseColor("#ABABAB");
    }

    public final List<Integer> getItems() {
        return this.items;
    }

    public final void setItems(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SettingsItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_settings_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SettingsItemViewHolder(inflate);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
        r2 = "???";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cb, code lost:
        r2 = "Передать лидерство семьи другому игроку";
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d2, code lost:
        r2 = "Внести или вынести игрока из черного списка";
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d9, code lost:
        r2 = "Редактировать  сообщение";
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e0, code lost:
        r2 = "Установить объявление для всех членов семьи";
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e7, code lost:
        r2 = "Установить кол-во дней для автоисключения";
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ee, code lost:
        r2 = "Установить цену поминутной аренды";
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f5, code lost:
        r2 = "Установить цену на выход из семьи";
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0144, code lost:
        r2 = "Выдать премию всем членам семьи";
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x014a, code lost:
        r2 = "Редактировать названия и настройки доступа рангам семьи";
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0150, code lost:
        r2 = "Установить % сбора на баланс семьи";
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x015b, code lost:
        r2 = "Привязать или изменить Discord - канал";
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0161, code lost:
        r2 = "Пополняйте или выводите средства и монеты";
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0167, code lost:
        r2 = "Изменить цвет, иконку, тип, название, слоган";
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016d, code lost:
        r2 = "Назначить или снять заместителя";
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(SettingsItemViewHolder holder, int i) {
        int i2;
        String str;
        String str2;
        int parseColor;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = (Integer) CollectionsKt.getOrNull(this.items, i);
        if (num != null) {
            final int intValue = num.intValue();
            FamilySettingsItemBinding binding = holder.getBinding();
            switch (intValue) {
                case 0:
                    i2 = R.drawable.family_settins_ic_deputy;
                    break;
                case 1:
                    i2 = R.drawable.family_settins_ic_customize;
                    break;
                case 2:
                    i2 = R.drawable.family_settins_ic_balance;
                    break;
                case 3:
                    i2 = R.drawable.family_settins_ic_disc;
                    break;
                case 4:
                    i2 = R.drawable.family_settins_ic_alliance;
                    break;
                case 5:
                    i2 = R.drawable.family_settins_ic_tax;
                    break;
                case 6:
                    i2 = R.drawable.family_settins_ic_rank;
                    break;
                case 7:
                    i2 = R.drawable.family_settins_ic_prem;
                    break;
                case 8:
                    i2 = R.drawable.family_settins_ic_official;
                    break;
                case 9:
                    i2 = R.drawable.family_settins_ic_brend;
                    break;
                case 10:
                    i2 = R.drawable.family_menu_ic_leave;
                    break;
                case 11:
                    i2 = R.drawable.family_settins_ic_transport;
                    break;
                case 12:
                    i2 = R.drawable.family_settins_ic_auto_kick;
                    break;
                case 13:
                    i2 = R.drawable.family_settins_ic_notification;
                    break;
                case 14:
                    i2 = R.drawable.family_settins_ic_message;
                    break;
                case 15:
                    i2 = R.drawable.family_settins_ic_block;
                    break;
                case 16:
                    i2 = R.drawable.family_settins_ic_leader;
                    break;
                case 17:
                    if (this.estate == 2) {
                        i2 = R.drawable.family_menu_ic_estate;
                        break;
                    } else {
                        i2 = R.drawable.family_menu_ic_apart;
                        break;
                    }
                default:
                    i2 = R.drawable.family_menu_ic_info;
                    break;
            }
            switch (intValue) {
                case 0:
                    str = "Управление заместителями";
                    break;
                case 1:
                    str = "Кастомизация";
                    break;
                case 2:
                    str = "Управление балансом";
                    break;
                case 3:
                    str = "Привязать Discord";
                    break;
                case 4:
                    str = "Управление альянсом";
                    break;
                case 5:
                    str = "Процент с депозитов участников";
                    break;
                case 6:
                    str = "Редактировать ранги";
                    break;
                case 7:
                    str = "Выдать премию";
                    break;
                case 8:
                    str = "Купить галочку";
                    break;
                case 9:
                    str = "Купить бренд";
                    break;
                case 10:
                    str = "Платный выход из семьи";
                    break;
                case 11:
                    str = "Аренда семейного транспорта";
                    break;
                case 12:
                    str = "Авто-исключение из семьи";
                    break;
                case 13:
                    str = "Объявление";
                    break;
                case 14:
                    str = "Приветственное сообщение";
                    break;
                case 15:
                    str = "Черный список";
                    break;
                case 16:
                    str = "Передать лидерство";
                    break;
                case 17:
                    if (this.estate != 2) {
                        str = "Семейная квартира";
                        break;
                    } else {
                        str = "Семейное поместье";
                        break;
                    }
                default:
                    str = "???";
                    break;
            }
            switch (intValue) {
                case 4:
                    str2 = this.allianceName;
                    break;
                case 8:
                    if (this.settingsData.getVerificationPrice() == -1) {
                        break;
                    } else {
                        str2 = MoneyElementKt.toMoneyFormattedSpannable$default(this.settingsData.getVerificationPrice(), false, "Цена: ", null, null, 13, null);
                        break;
                    }
                case 9:
                    if (this.settingsData.getBrandPrice() == -1) {
                        break;
                    } else {
                        str2 = MoneyElementKt.toMoneyFormattedSpannable$default(this.settingsData.getBrandPrice(), false, "Цена: ", null, null, 13, null);
                        break;
                    }
                case 17:
                    str2 = this.estate == 2 ? "Управлеине поместьем и улучшениями" : "Управление квартирой и улучшениями";
                    break;
            }
            if (intValue == 17) {
                if (this.estate == 2) {
                    parseColor = Color.parseColor("#1AE1AA33");
                } else {
                    parseColor = Color.parseColor("#0DFFFFFF");
                }
            } else {
                parseColor = Color.parseColor("#0DFFFFFF");
            }
            if (this.estate == 2 && intValue == 11) {
                binding.stroke.setVisibility(0);
                binding.itemTitle.setTextColor(this.estateColor);
                binding.itemDesc.setTextColor(this.estateColor);
            } else {
                binding.stroke.setVisibility(8);
                binding.itemTitle.setTextColor(-1);
                binding.itemDesc.setTextColor(this.descColor);
            }
            binding.levelImage.setImageResource(i2);
            binding.itemTitle.setText(str);
            binding.itemDesc.setText(str2);
            binding.card.setCardBackgroundColor(parseColor);
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.family.adapters.SettingsAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsAdapter.onBindViewHolder$lambda$0$0(SettingsAdapter.this, intValue, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(SettingsAdapter settingsAdapter, int i, View view) {
        settingsAdapter.onClick.invoke(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void setInfo(int i, FamilySettingsData settingsData) {
        Intrinsics.checkNotNullParameter(settingsData, "settingsData");
        List<Integer> mutableList = CollectionsKt.toMutableList(new IntRange(0, 17));
        this.items = mutableList;
        if (i == 0) {
            final Function1 function1 = new Function1() { // from class: com.arizonagames.feature.arizona.family.adapters.SettingsAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SettingsAdapter.setInfo$lambda$0((Integer) obj));
                }
            };
            mutableList.removeIf(new Predicate() { // from class: com.arizonagames.feature.arizona.family.adapters.SettingsAdapter$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean booleanValue;
                    booleanValue = ((Boolean) Function1.this.invoke(obj)).booleanValue();
                    return booleanValue;
                }
            });
        }
        this.estate = i;
        this.settingsData = settingsData;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setInfo$lambda$0(Integer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.intValue() == 17;
    }

    public final void setAllianceTitle(String title) {
        String str;
        Intrinsics.checkNotNullParameter(title, "title");
        if (title.length() == 0) {
            str = "Создать альянс";
        } else {
            str = title.toString();
        }
        this.allianceName = str;
        notifyDataSetChanged();
    }
}
