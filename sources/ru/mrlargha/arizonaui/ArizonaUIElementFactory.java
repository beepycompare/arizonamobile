package ru.mrlargha.arizonaui;

import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import ru.mrlargha.arizonaui.action.presentation.Action;
import ru.mrlargha.arizonaui.biz.MyBusinessScreen;
import ru.mrlargha.arizonaui.cars.CarsScreen;
import ru.mrlargha.arizonaui.container.presentation.CurrentContainer;
import ru.mrlargha.arizonaui.container.presentation.CurrentContainerRewards;
import ru.mrlargha.arizonaui.documents.DocumentsScreen;
import ru.mrlargha.arizonaui.donate.presentation.DonateShop;
import ru.mrlargha.arizonaui.family.FamilyScreen;
import ru.mrlargha.arizonaui.fishing.FishingScreen;
import ru.mrlargha.arizonaui.house.MyHouseScreen;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.new_container.NewContainerScreen;
import ru.mrlargha.arizonaui.plates.LicensePlatesScreen;
import ru.mrlargha.arizonaui.situation.SituationScreen;
import ru.mrlargha.commonui.core.UIElementFactory;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: ArizonaUIElementFactory.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/mrlargha/arizonaui/ArizonaUIElementFactory;", "Lru/mrlargha/commonui/core/UIElementFactory;", "<init>", "()V", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArizonaUIElementFactory extends UIElementFactory {
    public ArizonaUIElementFactory() {
        getSpawnerMap().putAll(MapsKt.mapOf(TuplesKt.to(UIElementID.ARIZONA_DONATE_SHOP, new DonateShop.Spawner()), TuplesKt.to(UIElementID.ARIZONA_CURRENT_CONTAINER, new CurrentContainer.Spawner()), TuplesKt.to(UIElementID.ARIZONA_CONTAINER_REWARDS, new CurrentContainerRewards.Spawner()), TuplesKt.to(UIElementID.ARIZONA_ACTION, new Action.Spawner()), TuplesKt.to(UIElementID.ARIZONA_MOBILE_PHONE, new MobilePhone.Spawner()), TuplesKt.to(UIElementID.ARIZONA_VEHICLE_PLATE, new LicensePlatesScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_SITUATION, new SituationScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_FISHING, new FishingScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_NEW_CONTAINER, new NewContainerScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_BUSINESS, new MyBusinessScreen.Spawner()), TuplesKt.to(UIElementID.CARS, new CarsScreen.Spawner()), TuplesKt.to(UIElementID.HOUSES, new MyHouseScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_DOCUMENTS, new DocumentsScreen.Spawner()), TuplesKt.to(UIElementID.FAMILY_ARIZONA, new FamilyScreen.Spawner())));
    }
}
