package ru.mrlargha.arizonaui;

import com.arizonagames.feature.arizona.cars.CarsScreen;
import com.arizonagames.feature.arizona.family.FamilyScreen;
import com.arizonagames.feature.minigames.atm.AtmScreen;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import ru.mrlargha.arizonaui.action.presentation.Action;
import ru.mrlargha.arizonaui.ghetto.GhettoScreen;
import ru.mrlargha.arizonaui.house.MyHouseScreen;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.plates.LicensePlatesScreen;
import ru.mrlargha.arizonaui.situation.SituationScreen;
import ru.mrlargha.commonui.core.UIElementFactory;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.employment.center.EmploymentScreen;
import ru.mrlargha.event.EventScreen;
import ru.mrlargha.feature.arizona.cases.CasesScreen;
import ru.mrlargha.feature.selector.presentation.SelectorScreen;
/* compiled from: ArizonaUIElementFactory.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/mrlargha/arizonaui/ArizonaUIElementFactory;", "Lru/mrlargha/commonui/core/UIElementFactory;", "<init>", "()V", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaUIElementFactory extends UIElementFactory {
    public ArizonaUIElementFactory() {
        getSpawnerMap().putAll(MapsKt.mapOf(TuplesKt.to(UIElementID.ARIZONA_ACTION, new Action.Spawner()), TuplesKt.to(UIElementID.ARIZONA_MOBILE_PHONE, new MobilePhone.Spawner()), TuplesKt.to(UIElementID.ARIZONA_VEHICLE_PLATE, new LicensePlatesScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_SITUATION, new SituationScreen.Spawner()), TuplesKt.to(UIElementID.HOUSES, new MyHouseScreen.Spawner()), TuplesKt.to(UIElementID.FAMILY_ARIZONA, new FamilyScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_GHETTO, new GhettoScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_EVENT, new EventScreen.Spawner()), TuplesKt.to(UIElementID.SELECTOR, new SelectorScreen.Spawner()), TuplesKt.to(UIElementID.CASES, new CasesScreen.Spawner()), TuplesKt.to(UIElementID.EMPLOYMENT_CENTER, new EmploymentScreen.Spawner()), TuplesKt.to(UIElementID.RODINA_EVENT, new EventScreen.Spawner()), TuplesKt.to(UIElementID.CARS, new CarsScreen.Spawner()), TuplesKt.to(UIElementID.ATM_MINIGAME, new AtmScreen.Spawner())));
    }
}
