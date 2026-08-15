package com.arizonagames.feature.arizona.family.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.launcher.UpdateServiceContract;
import com.arizonagames.feature.arizona.family.R;
import com.arizonagames.feature.arizona.family.data.FamilyEstateData;
import com.arizonagames.feature.arizona.family.databinding.FamilyEstateItemBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: EstateAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000eJ\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/arizonagames/feature/arizona/family/adapters/EstateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/family/adapters/EstateItemViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "isEstate", "", "estateData", "Lcom/arizonagames/feature/arizona/family/data/FamilyEstateData;", "flagTitle", "", "items", "", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "estateColor", "descColor", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setInfo", "info", "hasEstate", "setFlagTitle", "flag", "moneyRange", "", UpdateServiceContract.BundleKey.CURRENT, UpdateServiceContract.BundleKey.TOTAL, "family"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EstateAdapter extends RecyclerView.Adapter<EstateItemViewHolder> {
    private final int descColor;
    private final int estateColor;
    private FamilyEstateData estateData;
    private String flagTitle;
    private boolean isEstate;
    private List<Integer> items;
    private final Function1<Integer, Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public EstateAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.isEstate = true;
        this.estateData = new FamilyEstateData(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, CollectionsKt.emptyList());
        this.flagTitle = "Отсутствует";
        this.items = CollectionsKt.toMutableList(new IntRange(0, 16));
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
    public EstateItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_estate_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new EstateItemViewHolder(inflate);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01de, code lost:
        r4 = "Приобрести поместье вместо квартиры";
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e5, code lost:
        r4 = "Отметить местоположение в GPS";
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0226, code lost:
        r4 = "Опции продажи семейной квартиры";
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x022c, code lost:
        r4 = "Управление семейными бизнесами";
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0240, code lost:
        r4 = "Меню управления домом и настройки доступа";
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0246, code lost:
        r4 = "Настройки семейного автопарка и доступа к транспорту";
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x024c, code lost:
        r4 = "Приобретение и информация об улучшениях";
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01da, code lost:
        r4 = "???";
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(EstateItemViewHolder holder, int i) {
        int i2;
        String concat;
        String str;
        String str2;
        int parseColor;
        int i3;
        int i4;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = (Integer) CollectionsKt.getOrNull(this.items, i);
        if (num != null) {
            final int intValue = num.intValue();
            FamilyEstateItemBinding binding = holder.getBinding();
            if (intValue <= 3) {
                binding.card1.setVisibility(8);
                binding.card2.setVisibility(0);
                if (intValue == 0) {
                    i3 = R.drawable.family_estate_ic_adi_kit1;
                } else if (intValue == 1) {
                    i3 = R.drawable.family_estate_ic_armor1;
                } else if (intValue == 2) {
                    i3 = R.drawable.family_estate_ic_goods1;
                } else if (intValue == 3) {
                    i3 = R.drawable.family_estate_ic_items1;
                } else {
                    i3 = R.drawable.family_menu_ic_info;
                }
                if (intValue == 0) {
                    i4 = R.drawable.family_estate_ic_adi_kit;
                } else if (intValue == 1) {
                    i4 = R.drawable.family_estate_ic_armor;
                } else if (intValue == 2) {
                    i4 = R.drawable.family_estate_ic_goods;
                } else if (intValue == 3) {
                    i4 = R.drawable.family_estate_ic_items;
                } else {
                    i4 = R.drawable.family_estate_ic_adi_kit;
                }
                if (intValue == 0) {
                    str3 = "Аптечек";
                } else if (intValue == 1) {
                    str3 = "Бронежилетов";
                } else if (intValue == 2) {
                    str3 = "Семейные монеты";
                } else if (intValue != 3) {
                    str3 = "???";
                } else {
                    str3 = "Деньги";
                }
                if (intValue == 0) {
                    str4 = this.estateData.getMedkit() + " шт";
                } else {
                    str4 = intValue != 1 ? intValue != 2 ? intValue != 3 ? "???" : MoneyElementKt.toMoneyFormattedSpannable$default(this.estateData.getItems(), false, null, null, null, 15, null) : this.estateData.getProducts() + " шт" : this.estateData.getArmor() + " шт";
                }
                binding.level2Image.setImageResource(i3);
                binding.level2ImageBg.setImageResource(i4);
                binding.item2Title.setText(str3);
                binding.item2Desc.setText(str4);
            } else {
                binding.card2.setVisibility(8);
                binding.card1.setVisibility(0);
                switch (intValue) {
                    case 4:
                        i2 = R.drawable.family_estate_ic_door;
                        break;
                    case 5:
                        i2 = R.drawable.family_estate_ic_tax;
                        break;
                    case 6:
                        i2 = R.drawable.family_estate_ic_upgrade;
                        break;
                    case 7:
                        i2 = R.drawable.family_estate_ic_auto;
                        break;
                    case 8:
                        i2 = R.drawable.family_menu_ic_estate;
                        break;
                    case 9:
                        i2 = R.drawable.family_estate_ic_privacy;
                        break;
                    case 10:
                        i2 = R.drawable.family_estate_ic_business;
                        break;
                    case 11:
                        i2 = R.drawable.family_menu_ic_apart;
                        break;
                    case 12:
                        i2 = R.drawable.family_estate_ic_adi_kit2;
                        break;
                    case 13:
                        i2 = R.drawable.family_estate_ic_armor2;
                        break;
                    case 14:
                        i2 = R.drawable.family_estate_ic_flag;
                        break;
                    case 15:
                        i2 = R.drawable.family_settins_ic_location;
                        break;
                    case 16:
                        i2 = R.drawable.family_menu_ic_estate;
                        break;
                    default:
                        i2 = R.drawable.family_menu_ic_info;
                        break;
                }
                switch (intValue) {
                    case 4:
                        concat = (this.estateData.getDoorOpened() == 0 ? "Открыть дверь в " : "Закрыть дверь в ").concat(this.isEstate ? "поместье" : "квартиру");
                        break;
                    case 5:
                        concat = "Оплатить налог на квартиру";
                        break;
                    case 6:
                        concat = "Улучшения";
                        break;
                    case 7:
                        concat = "Автопарк";
                        break;
                    case 8:
                        concat = "Управление домом семьи";
                        break;
                    case 9:
                        concat = "Настройки доступа";
                        break;
                    case 10:
                        concat = "Семейные бизнесы";
                        break;
                    case 11:
                        concat = "Продажа семейной квартиры";
                        break;
                    case 12:
                        concat = "Купить аптечки на склад";
                        break;
                    case 13:
                        concat = "Купить бронежилеты на склад";
                        break;
                    case 14:
                        concat = "Семейный флаг";
                        break;
                    case 15:
                        concat = "Найти квартиру";
                        break;
                    case 16:
                        concat = "Купить поместье";
                        break;
                    default:
                        concat = "???";
                        break;
                }
                if (intValue != 4) {
                    if (intValue == 5) {
                        if (this.estateData.getTaxCurrent() >= 1000000) {
                            binding.itemDesc.setTextColor(Color.parseColor("#FE5B3B"));
                        } else {
                            binding.itemDesc.setTextColor(this.descColor);
                        }
                    } else {
                        binding.itemDesc.setTextColor(this.descColor);
                    }
                } else if (this.estateData.getDoorOpened() != 1) {
                    binding.itemDesc.setTextColor(Color.parseColor("#FE5B3B"));
                } else {
                    binding.itemDesc.setTextColor(Color.parseColor("#C1FF3D"));
                }
                switch (intValue) {
                    case 4:
                        str = this.estateData.getDoorOpened() == 0 ? "Закрыта" : "Открыта";
                        break;
                    case 5:
                        str = moneyRange(this.estateData.getTaxCurrent(), this.estateData.getTaxTotal());
                        break;
                    case 9:
                        if (this.isEstate) {
                            str2 = "‘Настройки доступа к семейному поместью и складу";
                        } else {
                            str2 = "Настройки доступа к семейной квартире и складу";
                        }
                        str = str2;
                        break;
                    case 12:
                        str = this.estateData.getMedkitPrice() + " единиц семейной репутации";
                        break;
                    case 13:
                        str = this.estateData.getArmorPrice() + " единиц семейной репутации";
                        break;
                    case 14:
                        str = this.flagTitle;
                        break;
                }
                if (intValue == 8) {
                    parseColor = Color.parseColor("#1AE1AA33");
                } else if (intValue == 16) {
                    parseColor = Color.parseColor("#1AE1AA33");
                } else {
                    parseColor = Color.parseColor("#0DFFFFFF");
                }
                if (intValue == 8 || intValue == 16) {
                    binding.stroke.setVisibility(0);
                    binding.itemTitle.setTextColor(this.estateColor);
                    binding.itemDesc.setTextColor(this.estateColor);
                } else {
                    binding.stroke.setVisibility(8);
                    binding.itemTitle.setTextColor(-1);
                    binding.itemDesc.setTextColor(this.descColor);
                }
                binding.levelImage.setImageResource(i2);
                binding.itemTitle.setText(concat);
                binding.itemDesc.setText(str);
                binding.card1.setCardBackgroundColor(parseColor);
            }
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.family.adapters.EstateAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EstateAdapter.onBindViewHolder$lambda$0$0(intValue, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(int i, EstateAdapter estateAdapter, View view) {
        if (i >= 4) {
            estateAdapter.onClick.invoke(Integer.valueOf(i - 4));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void setInfo(FamilyEstateData info, int i) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.estateData = info;
        List<Integer> mutableList = CollectionsKt.toMutableList(new IntRange(0, 3));
        List<Integer> menuIds = info.getMenuIds();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(menuIds, 10));
        for (Number number : menuIds) {
            arrayList.add(Integer.valueOf(number.intValue() + 4));
        }
        mutableList.addAll(arrayList);
        this.items = mutableList;
        this.isEstate = i == 2;
        notifyDataSetChanged();
    }

    public final void setFlagTitle(String flag) {
        String str;
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (flag.length() == 0) {
            str = "Отсутствует";
        } else {
            str = flag.toString();
        }
        this.flagTitle = str;
        notifyDataSetChanged();
    }

    private final CharSequence moneyRange(int i, int i2) {
        ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
        String formatPlain = MoneyFormatter.INSTANCE.formatPlain(i);
        return ChatEmoji.toSpannable$default(chatEmoji, ":cash: " + formatPlain + " / " + MoneyFormatter.INSTANCE.formatPlain(i2), 0.0f, null, 3, null);
    }
}
