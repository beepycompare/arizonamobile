package ru.mrlargha.feature.common_factory;

import com.arizonagames.feature.arizona.certificate.CertificateScreen;
import com.arizonagames.feature.minigames.blueprint.BlueprintScreen;
import com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen;
import com.arizonagames.feature.minigames.fishing.FishingScreen;
import com.arizonagames.feature.minigames.fishing.backend.FishingBackendScreen;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import ru.mrlargha.arizona.promo.ArizonaPromoScreen;
import ru.mrlargha.arizona.rating.ItemRatingScreen;
import ru.mrlargha.arizonaui.biz.MyBusinessScreen;
import ru.mrlargha.commonui.core.UIElementFactory;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.CustomKeyboard;
import ru.mrlargha.commonui.elements.EmptyScreen;
import ru.mrlargha.commonui.elements.InteractionButton;
import ru.mrlargha.commonui.elements.UniversalActionScreen;
import ru.mrlargha.commonui.elements.account_linking.LinkingScreen;
import ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground;
import ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings;
import ru.mrlargha.commonui.elements.azvoice.AzVoiceUserSettings;
import ru.mrlargha.commonui.elements.casino.CasinoScreen;
import ru.mrlargha.commonui.elements.catalog.CatalogScreen;
import ru.mrlargha.commonui.elements.cinemaeffect.CinemaEffectPage;
import ru.mrlargha.commonui.elements.craft.presentation.CraftScreen;
import ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog;
import ru.mrlargha.commonui.elements.dice.DiceScreen;
import ru.mrlargha.commonui.elements.donate.presentation.DonateScreen;
import ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen;
import ru.mrlargha.commonui.elements.event.BpEventChoiceScreen;
import ru.mrlargha.commonui.elements.gasstation.presentation.GasStation;
import ru.mrlargha.commonui.elements.hints.HintsScreen;
import ru.mrlargha.commonui.elements.hud.presentation.Hud;
import ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen;
import ru.mrlargha.commonui.elements.menu.Menu;
import ru.mrlargha.commonui.elements.metaldetector.MetaldetectorScreen;
import ru.mrlargha.commonui.elements.new_container.NewContainerScreen;
import ru.mrlargha.commonui.elements.personalproperty.PersonalPropertyScreen;
import ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen;
import ru.mrlargha.commonui.elements.products.ProductsScreen;
import ru.mrlargha.commonui.elements.quest.QuestDialogScreen;
import ru.mrlargha.commonui.elements.quest.QuestScreen;
import ru.mrlargha.commonui.elements.quest.presentation.NewQuestScreen;
import ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen;
import ru.mrlargha.commonui.elements.rewards_screen.RewardsScreen;
import ru.mrlargha.commonui.elements.roulette.CaseRouletteScreen;
import ru.mrlargha.commonui.elements.shop.LavkaTypeScreen;
import ru.mrlargha.commonui.elements.shop.ShopScreen;
import ru.mrlargha.commonui.elements.streetFood.StreetFoodScreen;
import ru.mrlargha.commonui.elements.trade.presentation.TradeScreen;
import ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen;
import ru.mrlargha.commonui.elements.video_advice.VideoAdvice;
import ru.mrlargha.commonui.elements.workshop.PotionsScreen;
import ru.mrlargha.commonui.elements.workshop.WorkshopScreen;
import ru.mrlargha.feature.battle_pass_view.UserBattlePass;
import ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen;
import ru.mrlargha.feature.calendar.DailyRewardsScreen;
import ru.mrlargha.feature.documents.DocumentsScreen;
import ru.mrlargha.feature.starter_pack.StarterPackScreen;
import ru.mrlargha.rodina_ui.screens.excavation.ExcavationScreen;
/* compiled from: CommonElementsFactory.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/mrlargha/feature/common_factory/CommonElementsFactory;", "Lru/mrlargha/commonui/core/UIElementFactory;", "<init>", "()V", "common-factory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CommonElementsFactory extends UIElementFactory {
    public CommonElementsFactory() {
        getSpawnerMap().putAll(MapsKt.mapOf(TuplesKt.to(UIElementID.ANIMATION_MENU, new AnimationMenu.Spawner()), TuplesKt.to(UIElementID.VOICE_SETTINGS, new AzVoiceSettings.Spawner()), TuplesKt.to(UIElementID.VOICE_PLAYERS_SETTINGS, new AzVoiceUserSettings.Spawner()), TuplesKt.to(UIElementID.RADIAL_MENU, new RadialMenuScreen.Spawner()), TuplesKt.to(UIElementID.HUD, new Hud.Spawner()), TuplesKt.to(UIElementID.AUTHORIZATION, new RegistrationVideoBackground.Spawner()), TuplesKt.to(UIElementID.MAIN_MENU, new Menu.Spawner()), TuplesKt.to(UIElementID.INTERACTION_BUTTON, new InteractionButton.Spawner()), TuplesKt.to(UIElementID.INPUT_LAYOUT, new CustomKeyboard.Spawner()), TuplesKt.to(UIElementID.MAIN_BATTLE_PASS, new Winter2025BattlePassScreen.Spawner()), TuplesKt.to(UIElementID.DICE_SCREEN, new DiceScreen.Spawner()), TuplesKt.to(UIElementID.UNIVERSAL_ACTION, new UniversalActionScreen.Spawner()), TuplesKt.to(UIElementID.QUEST_DIALOG, new QuestDialogScreen.Spawner()), TuplesKt.to(UIElementID.QUESTS_SCREEN, new QuestScreen.Spawner()), TuplesKt.to(UIElementID.PERSONAL_PROPERTY, new PersonalPropertyScreen.Spawner()), TuplesKt.to(UIElementID.USER_BATTLE_PASS, new UserBattlePass.Spawner()), TuplesKt.to(UIElementID.EMPLOYMENT_TASK, new EmploymentTaskScreen.Spawner()), TuplesKt.to(UIElementID.PLAYER_LIST, new PlayerListDialog.Spawner()), TuplesKt.to(UIElementID.VIDEO_ADVICE, new VideoAdvice.Spawner()), TuplesKt.to(UIElementID.TUNING_SCREEN, new TuningAutoScreen.Spawner()), TuplesKt.to(UIElementID.CASE_ROULETTE, new CaseRouletteScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_GAS_STATION, new GasStation.Spawner()), TuplesKt.to(UIElementID.CINEMA_EFFECT, new CinemaEffectPage.Spawner()), TuplesKt.to(UIElementID.INVENTORY, new InventoryScreen.Spawner()), TuplesKt.to(UIElementID.TRADE, new TradeScreen.Spawner()), TuplesKt.to(UIElementID.CRAFT, new CraftScreen.Spawner()), TuplesKt.to(UIElementID.WORKSHOP, new WorkshopScreen.Spawner()), TuplesKt.to(UIElementID.INVENTORY_SECURITY_SCREEN, new EmptyScreen.Spawner()), TuplesKt.to(UIElementID.INVENTORY_VEHICLE_SCREEN, new EmptyScreen.Spawner()), TuplesKt.to(UIElementID.INVENTORY_WALLET_SCREEN, new EmptyScreen.Spawner()), TuplesKt.to(UIElementID.INVENTORY_WAREHOUSE, new EmptyScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_GLOVO, new LavkaTypeScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_LAVKA, new ShopScreen.Spawner()), TuplesKt.to(UIElementID.PREVIEW_USER_INVENTORY, new PreviewInventoryScreen.Spawner()), TuplesKt.to(UIElementID.LINKING, new LinkingScreen.Spawner()), TuplesKt.to(UIElementID.CASINO, new CasinoScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_BANNERS, new EmptyScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_STREET_FOOD, new StreetFoodScreen.Spawner()), TuplesKt.to(UIElementID.HINTS, new HintsScreen.Spawner()), TuplesKt.to(UIElementID.POTIONS, new PotionsScreen.Spawner()), TuplesKt.to(UIElementID.CATALOG, new CatalogScreen.Spawner()), TuplesKt.to(UIElementID.PRODUCTS_SCREEN, new ProductsScreen.Spawner()), TuplesKt.to(UIElementID.RODINA_NEW_QUEST, new NewQuestScreen.Spawner()), TuplesKt.to(UIElementID.REWARDS_SCREEN, new RewardsScreen.Spawner()), TuplesKt.to(UIElementID.DAILY_REWARD, new DailyRewardsScreen.Spawner()), TuplesKt.to(UIElementID.BATTLE_PASS, new Winter2025BattlePassScreen.Spawner()), TuplesKt.to(UIElementID.BLUEPRINT, new BlueprintScreen.Spawner()), TuplesKt.to(UIElementID.CONVEYOR_GAME, new ConveyorGameScreen.Spawner()), TuplesKt.to(UIElementID.BP_EVENT_CHOICE, new BpEventChoiceScreen.Spawner()), TuplesKt.to(UIElementID.RODINA_EXCAVATION_SCREEN, new ExcavationScreen.Spawner()), TuplesKt.to(UIElementID.RODINA_METAL_DETECTOR, new MetaldetectorScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_NEW_CONTAINER, new NewContainerScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_DONATE_SHOP, new DonateScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_DOCUMENTS, new DocumentsScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_BUSINESS, new MyBusinessScreen.Spawner()), TuplesKt.to(UIElementID.STARTER_PACK_RODINA, new StarterPackScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_FISHING, new FishingScreen.Spawner()), TuplesKt.to(UIElementID.FISHING_BACKEND, new FishingBackendScreen.Spawner()), TuplesKt.to(UIElementID.ARIZONA_RATING, new ItemRatingScreen.Spawner()), TuplesKt.to(UIElementID.CERTIFICATE, new CertificateScreen.Spawner()), TuplesKt.to(UIElementID.RODINA_PROMO, new ArizonaPromoScreen.Spawner())));
    }
}
