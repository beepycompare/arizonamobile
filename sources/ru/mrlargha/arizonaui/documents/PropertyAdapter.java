package ru.mrlargha.arizonaui.documents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.DocumentsPropertyItemBinding;
import ru.mrlargha.arizonaui.documents.data.PropertyItem;
/* compiled from: PropertyAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017J\u0006\u0010\u0018\u001a\u00020\u0011R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/documents/PropertyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/documents/PropertyViewHolder;", "<init>", "()V", "allList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/documents/data/PropertyItem;", "Lkotlin/collections/ArrayList;", "getAllList", "()Ljava/util/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addElements", "list", "", "clearAllTasksList", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PropertyAdapter extends RecyclerView.Adapter<PropertyViewHolder> {
    private final ArrayList<PropertyItem> allList = new ArrayList<>();

    public final ArrayList<PropertyItem> getAllList() {
        return this.allList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PropertyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.documents_property_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new PropertyViewHolder(inflate);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PropertyViewHolder holder, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        PropertyItem propertyItem = this.allList.get(i);
        Intrinsics.checkNotNullExpressionValue(propertyItem, "get(...)");
        PropertyItem propertyItem2 = propertyItem;
        DocumentsPropertyItemBinding binding = holder.getBinding();
        binding.documentsPropertyItemText.setText(propertyItem2.getText());
        String property_type = propertyItem2.getProperty_type();
        switch (property_type.hashCode()) {
            case -1884476133:
                if (property_type.equals("pawn-shop")) {
                    i2 = R.drawable.documents_ic_pawn_shop;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1844676641:
                if (property_type.equals("oil-rig-water")) {
                    i2 = R.drawable.documents_ic_oil_rig;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1792901185:
                if (property_type.equals("oil-rig-ground")) {
                    i2 = R.drawable.documents_ic_oil_rig_lv;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1742473807:
                if (property_type.equals("tunning-salon")) {
                    i2 = R.drawable.documents_ic_tunning_shop_sf;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1575427166:
                if (property_type.equals("admin-stall")) {
                    i2 = R.drawable.documents_ic_stall_admin;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1568935349:
                if (property_type.equals("strip-club")) {
                    i2 = R.drawable.documents_ic_strip_club;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1534288057:
                if (property_type.equals("property-exchange-center")) {
                    i2 = R.drawable.documents_ic_change_center;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1495947919:
                if (property_type.equals("food-stall")) {
                    i2 = R.drawable.documents_ic_food_stall;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1494830709:
                if (property_type.equals("convenience-store")) {
                    i2 = R.drawable.documents_ic_convenience_store;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1452492292:
                if (property_type.equals("food-stall-road")) {
                    i2 = R.drawable.documents_ic_food2;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1432262505:
                if (property_type.equals("auto-service")) {
                    i2 = R.drawable.documents_ic_mechanics_auto_service;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1370098047:
                if (property_type.equals("sport-palace")) {
                    i2 = R.drawable.documents_ic_sport_palace;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1360334095:
                if (property_type.equals("cinema")) {
                    i2 = R.drawable.documents_ic_cinema;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1160980947:
                if (property_type.equals("farm-shop")) {
                    i2 = R.drawable.documents_ic_cotton_farm;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1158410575:
                if (property_type.equals("parking-space")) {
                    i2 = R.drawable.documents_ic_parking_space;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -1067215565:
                if (property_type.equals("trailer")) {
                    i2 = R.drawable.documents_ic_icon_trailer;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -868067634:
                if (property_type.equals("dance-school")) {
                    i2 = R.drawable.documents_ic_dance_school;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -708567108:
                if (property_type.equals("electro-company")) {
                    i2 = R.drawable.documents_ic_electricity;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -593039331:
                if (property_type.equals("fuel-station")) {
                    i2 = R.drawable.documents_ic_fuel_station;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -486648565:
                if (property_type.equals("electronics-store")) {
                    i2 = R.drawable.documents_ic_electronics_store;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -342531183:
                if (property_type.equals("car-rent-farm")) {
                    i2 = R.drawable.documents_ic_farm;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -190855083:
                if (property_type.equals("car-market")) {
                    i2 = R.drawable.documents_ic_car_market;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case -58146414:
                if (property_type.equals("car-rent")) {
                    i2 = R.drawable.documents_ic_car_rent;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 97299:
                if (property_type.equals("bar")) {
                    i2 = R.drawable.documents_ic_bar;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 2997966:
                if (property_type.equals("ammo")) {
                    i2 = R.drawable.documents_ic_ammo;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 3135542:
                if (property_type.equals("farm")) {
                    i2 = R.drawable.documents_ic_farm2;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 3145593:
                if (property_type.equals("flat")) {
                    i2 = R.drawable.documents_ic_icon_apart;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 9905691:
                if (property_type.equals("clothing-shop")) {
                    i2 = R.drawable.documents_ic_clothing_shop;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 99467700:
                if (property_type.equals("hotel")) {
                    i2 = R.drawable.documents_ic_icon_hotelroom;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 99469088:
                if (property_type.equals("house")) {
                    i2 = R.drawable.documents_ic_icon_house;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 109757344:
                if (property_type.equals("stall")) {
                    i2 = R.drawable.documents_ic_stall;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 188400688:
                if (property_type.equals("elixir-master")) {
                    i2 = R.drawable.documents_ic_elixir_master;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 216982060:
                if (property_type.equals("clothing-workshop")) {
                    i2 = R.drawable.documents_ic_clothing_workshop;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 218908200:
                if (property_type.equals("second-hand")) {
                    i2 = R.drawable.documents_ic_second_hand;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 354670409:
                if (property_type.equals("lottery")) {
                    i2 = R.drawable.documents_ic_horse_racing_lotery;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 577622612:
                if (property_type.equals("info-center")) {
                    i2 = R.drawable.documents_ic_info_center;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 605823065:
                if (property_type.equals("fishing-shop")) {
                    i2 = R.drawable.documents_ic_fishing_shop;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 616407998:
                if (property_type.equals("storage-point")) {
                    i2 = R.drawable.documents_ic_storage_point;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 619200308:
                if (property_type.equals("storage-space")) {
                    i2 = R.drawable.documents_ic_storage_space;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 625065103:
                if (property_type.equals("test-drive")) {
                    i2 = R.drawable.documents_ic_car_market_test;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 772969253:
                if (property_type.equals("car-market-vc")) {
                    i2 = R.drawable.documents_ic_car_market_salon;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 929029481:
                if (property_type.equals("boat-market")) {
                    i2 = R.drawable.documents_ic_boat_market;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 954268742:
                if (property_type.equals("private-bank")) {
                    i2 = R.drawable.documents_ic_private_ban;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 1030751613:
                if (property_type.equals("easter-stall")) {
                    i2 = R.drawable.documents_ic_fastfood_store_easer;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 1052176642:
                if (property_type.equals("tunning-shop")) {
                    i2 = R.drawable.documents_ic_tunning_shop;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 1225089391:
                if (property_type.equals("mechanics")) {
                    i2 = R.drawable.documents_ic_mechanics_repair;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 1231401073:
                if (property_type.equals("warehouse-truckers")) {
                    i2 = R.drawable.documents_ic_warehouse_truck;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 1659890833:
                if (property_type.equals("test-drive-admin")) {
                    i2 = R.drawable.documents_ic_test_drive_admin;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 2037180155:
                if (property_type.equals("bookmaker")) {
                    i2 = R.drawable.documents_ic_bookmaker;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            case 2085719044:
                if (property_type.equals("accessories-store")) {
                    i2 = R.drawable.documents_ic_accessories_store;
                    break;
                }
                i2 = R.drawable.documents_ic_icon_house;
                break;
            default:
                i2 = R.drawable.documents_ic_icon_house;
                break;
        }
        binding.documentsPropertyItemIc.setImageResource(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.allList.size();
    }

    public final void addElements(List<PropertyItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.allList.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearAllTasksList() {
        this.allList.clear();
        notifyDataSetChanged();
    }
}
