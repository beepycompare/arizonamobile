package ru.mrlargha.commonui.elements.radial_menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: SectorData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\"\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"createSectorDataListFromActions", "", "Lru/mrlargha/commonui/elements/radial_menu/SectorData;", "actionCodes", "", "actions", "", "Lru/mrlargha/commonui/elements/radial_menu/Action;", "getActions", "()Ljava/util/Map;", "CommonUI_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectorDataKt {
    private static final Map<String, Action> actions = MapsKt.mapOf(TuplesKt.to("-1", new Action("Настроить", R.drawable.pie_settings_icon)), TuplesKt.to("Greet", new Action("Поприветствовать", R.drawable.pie_greeting_new)), TuplesKt.to("Trade", new Action("Обмен", R.drawable.pie_trade_new)), TuplesKt.to("Say", new Action("Прошептать", R.drawable.pie_whisper_new)), TuplesKt.to("Showdock", new Action("Показать документы", R.drawable.pie_documents_new)), TuplesKt.to("Showskill", new Action("Показать навыки", R.drawable.pie_skills_new)), TuplesKt.to("Showdskill", new Action("Показать навыки вождения", R.drawable.pie_car_skills)), TuplesKt.to("Kiss", new Action("Поцеловать", R.drawable.pie_kiss_new)), TuplesKt.to("Showbinfo", new Action("Показать статистику бизнес", R.drawable.pie_business_stat_new)), TuplesKt.to("Wanted", new Action("Выдать розыск", R.drawable.pie_increase_wanted)), TuplesKt.to("Clearwanted", new Action("Очистить розыск", R.drawable.cleart_wanted)), TuplesKt.to("Take", new Action("Отобрать", R.drawable.select_item)), TuplesKt.to("Frisk", new Action("Обыскать", R.drawable.search_user)), TuplesKt.to("Cuff", new Action("Надеть/Снять наручники", R.drawable.pie_handcuffs)), TuplesKt.to("Ticket", new Action("Выписать штраф", R.drawable.write_ticket)), TuplesKt.to("Bot", new Action("Отобрать скрепки", R.drawable.take_clips)), TuplesKt.to("Gotome", new Action("Вести за собой", R.drawable.pie_to_lead)), TuplesKt.to("Bug", new Action("Прикрепить жучок", R.drawable.pie_attach_bug)), TuplesKt.to("Punish", new Action("Повысить срок", R.drawable.pie_raise_deadline)), TuplesKt.to("UnPunish", new Action("Понизить срок", R.drawable.pie_lower_deadline)), TuplesKt.to("GetJail", new Action("Узнать срок", R.drawable.pie_find_out_deadline)), TuplesKt.to("Medcard", new Action("Выдать мед. карту", R.drawable.pie_issue_medcard)), TuplesKt.to("Heal", new Action("Вылечить игрока", R.drawable.pie_heal_player)), TuplesKt.to("Healbad", new Action("Лечить от наркозависимости", R.drawable.pie_heal_from_narco)), TuplesKt.to("Recept", new Action("Выписать рецепт", R.drawable.pie_writing_recipe)), TuplesKt.to("Unstuff", new Action("Удалить татуировку", R.drawable.pie_delete_tattoo)), TuplesKt.to("Expel", new Action("Выпроводить игрока", R.drawable.pie_send_player_out)), TuplesKt.to("BankMenu", new Action("Банковское меню", R.drawable.pie_bank_menu)), TuplesKt.to("Live", new Action("Взять интервью", R.drawable.pie_interview)), TuplesKt.to("MInvite", new Action("Пригласить попрошайкой", R.drawable.pie_invite_beggar)), TuplesKt.to("Givebiz", new Action("Отдать бизнес", R.drawable.pie_giveaway_business)), TuplesKt.to("Stuff", new Action("Набить татуировку", R.drawable.pie_get_tattoo)), TuplesKt.to("Duel", new Action("Предложить дуэль", R.drawable.pie_propose_duel)), TuplesKt.to("Sellgangzone", new Action("Продать территорию", R.drawable.pie_sell_territory)), TuplesKt.to("Blacklist", new Action("Черный список", R.drawable.pie_blacklist)), TuplesKt.to("Invite", new Action("Принять игрока", R.drawable.pie_accept_player)), TuplesKt.to("UnInvite", new Action("Уволить игрока", R.drawable.pie_fire_player)), TuplesKt.to("Giverank", new Action("Повысить игрока", R.drawable.pie_promote_player)), TuplesKt.to("ViewPlayer", new Action("Осмотреть игрока", R.drawable.icon_clothes)), TuplesKt.to("FWarn", new Action("Выдать выговор", R.drawable.pie_issue_reprimand)), TuplesKt.to("UNFWarn", new Action("Снять выговор", R.drawable.pie_remove_reprimand)), TuplesKt.to("FMute", new Action("Выдать заглушку", R.drawable.pie_mute)), TuplesKt.to("UNFMute", new Action("Снять заглушку", R.drawable.pie_unmute)), TuplesKt.to("OpenBag", new Action("Взаимодействие с багажником", R.drawable.pie_car_trunk_new)), TuplesKt.to("OpenCap", new Action("Взаимодействие с капотом", R.drawable.pie_car_hood_new)), TuplesKt.to("OpenCar", new Action("Взаимодействие с дверьми", R.drawable.pie_car_doors_new)), TuplesKt.to("OpenGlass", new Action("Взаимодействие с стеклами", R.drawable.pie_car_windows_new)), TuplesKt.to("FuelCar", new Action("Дозаправить", R.drawable.pie_car_refueling_new)), TuplesKt.to("SFuelCar", new Action("Заправить", R.drawable.pie_car_fueling)), TuplesKt.to("ONLight", new Action("Взаимодействие с освещением", R.drawable.pie_car_lights_new)), TuplesKt.to("PaintCar", new Action("Покрасить", R.drawable.pie_car_painting_new)), TuplesKt.to("RepairCar", new Action("Починить", R.drawable.pie_fix)), TuplesKt.to("SpeedLimit", new Action("Переключить ограничитель", R.drawable.pie_toogle_limiter)), TuplesKt.to("CarFlip", new Action("Поднять машину", R.drawable.pie_up_car)), TuplesKt.to("CarHack", new Action("Взломать замок", R.drawable.pie_break_lock)), TuplesKt.to("TakDance", new Action("Взаимоствовать танец", R.drawable.pie_dance)), TuplesKt.to("ThSpikes", new Action("Сбросить шипы", R.drawable.pie_throw_off_spikes)), TuplesKt.to("DriveStyle", new Action("Изменить стиль езды", R.drawable.pie_change_drivestyle)), TuplesKt.to("RadioCar", new Action("Радио", R.drawable.pie_radio_car)), TuplesKt.to("KeyCar", new Action("Вставить / Достать ключи", R.drawable.pie_key_car)), TuplesKt.to("EngineCar", new Action("Двигатель", R.drawable.pie_engine)), TuplesKt.to("ParkingCar", new Action("Припарковать транспорт", R.drawable.pie_parking_car)), TuplesKt.to("RobbingCar", new Action("Обворовать транспорт", R.drawable.car_robbery)), TuplesKt.to("SearchCar", new Action("Пробить номера", R.drawable.search_car_plate)), TuplesKt.to("GiveMoney", new Action("Предложить взятку", R.drawable.give_money)), TuplesKt.to("LicenseNumber", new Action("Продать разрешение на получение номера", R.drawable.license_number)), TuplesKt.to("PoliceMan", new Action("Полицейский", R.drawable.policeman)), TuplesKt.to("Agenda", new Action("Выдать повестку", R.drawable.give_army)));

    public static final List<SectorData> createSectorDataListFromActions(List<String> actionCodes) {
        Intrinsics.checkNotNullParameter(actionCodes, "actionCodes");
        List<String> list = actionCodes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            Action action = actions.get(str);
            if (action == null) {
                throw new IllegalArgumentException("\"" + str + "\" not declared in Java Frontend");
            }
            arrayList.add(new SectorData(i, action, str, 0));
            i = i2;
        }
        return arrayList;
    }

    public static final Map<String, Action> getActions() {
        return actions;
    }
}
