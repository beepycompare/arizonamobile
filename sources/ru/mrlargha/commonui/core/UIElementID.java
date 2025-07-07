package ru.mrlargha.commonui.core;

import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import io.appmetrica.analytics.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UIElementID.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\bu\b\u0086\u0081\u0002\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001yB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bx¨\u0006z"}, d2 = {"Lru/mrlargha/commonui/core/UIElementID;", "", "id", "", "projectType", "Lru/mrlargha/commonui/core/ProjectType;", "<init>", "(Ljava/lang/String;IILru/mrlargha/commonui/core/ProjectType;)V", "getId", "()I", "getProjectType", "()Lru/mrlargha/commonui/core/ProjectType;", "COMMAND_BINDER", "VOICE_SETTINGS", "VOICE_PLAYERS_SETTINGS", "DIALOG", "RADIAL_MENU", "SNACKBAR", "ANIMATION_MENU", "HUD", "AUTHORIZATION", "RODINA_SELECT_CHARACTER", "RODINA_PARK_MENU", "RODINA_VEHICLE_DOCUMENT", "RODINA_REGISTRATION_REFERRAL", "RODINA_REFERRAL", "QUEST_DIALOG", "RODINA_CAPTURE", "PERSONAL_PROPERTY", "RODINA_EMPLOYMENT_CENTER", "RODINA_SHOP_SCREEN", "RODINA_VEHICLE_LIST", "RODINA_METAL_DETECTOR", "RODINA_JOB_MAIN_SCREEN", "RODINA_JOB_RATING_SCREEN", "RODINA_JOB_CONTRACTS_SCREEN", "UNIVERSAL_ACTION", "RODINA_CONTAINER_SCREEN", "RODINA_LATCHKEY_SCREEN", "RODINA_EXCAVATION_SCREEN", "QUESTS_SCREEN", "RODINA_LICENSE_PLATES_SCREEN", "RODINA_SERVICE_STATION", "RODINA_MOBILE_PHONE", "DICE_SCREEN", "RODINA_UNIVERSAL_MENU", "RODINA_DRIFT_SCORE_SCREEN", "RODINA_CAPTCHA_SCREEN", "ARIZONA_PASS_PROMO", "USER_BATTLE_PASS", "MAIN_BATTLE_PASS", "NEWBIE_BATTLE_PASS", "ARIZONA_DONATE_SHOP", "ARIZONA_CONTAINER", "ARIZONA_CURRENT_CONTAINER", "ARIZONA_CONTAINER_REWARDS", "ARIZONA_ACTION", "ARIZONA_MOBILE_PHONE", "ARIZONA_GAS_STATION", "CINEMA_EFFECT", "RODINA_NEW_QUEST", "ARIZONA_VEHICLE_PLATE", "INVENTORY", "INTERACTION_BUTTON", "MAIN_MENU", "ARIZONA_STREET_FOOD", "PLAYER_LIST", "TRADE", "CRAFT", "WORKSHOP", "ARIZONA_GLOVO", "ARIZONA_LAVKA", "INPUT_LAYOUT", "STREAM_VIDEO", "INVENTORY_SECURITY_SCREEN", "INVENTORY_WAREHOUSE", "INVENTORY_VEHICLE_SCREEN", "INVENTORY_WALLET_SCREEN", "PRODUCTS_SCREEN", "RODINA_CHOOSE_INTERIOR", "RODINA_UPGRADE_HOME", "PREVIEW_USER_INVENTORY", "VIDEO_ADVICE", "TUNING_SCREEN", "EMPLOYMENT_TASK", "CASE_ROULETTE", "FLASH_GRENADE", "SHOOTING_GALLERY", "FRACTION_STAT", "ARIZONA_SITUATION", "ARIZONA_FISHING", "ARIZONA_NEW_CONTAINER", "ARIZONA_BANNERS", "ARIZONA_BUSINESS", "TRAIN_JOB", "COLLECTOR_JOB", "HINTS", "DAILY_REWARD", "LINKING", "SKILLS", "CARS", "HOUSES", "POTIONS", "CASINO", "REWARDS_SCREEN", "BLUEPRINT", "BATTLE_PASS", "CATALOG", "NEIGHBOR_GAME_TASK", "NEIGHBOR_GAME", "ARIZONA_DOCUMENTS", "GROOMING", "AGREEMENT_SCREEN", "FAMILY_RODINA", "EASTER_MENU", "BP_EVENT_CHOICE", "CONVEYOR_GAME", "IMPROVEMENT_PREMIUM_VIP", "CASES", "FAMILY_ARIZONA", "STARTER_PACK_RODINA", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UIElementID {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UIElementID[] $VALUES;
    public static final Companion Companion;
    private final int id;
    private final ProjectType projectType;
    public static final UIElementID COMMAND_BINDER = new UIElementID("COMMAND_BINDER", 0, 1, ProjectType.COMMON);
    public static final UIElementID VOICE_SETTINGS = new UIElementID("VOICE_SETTINGS", 1, 2, ProjectType.COMMON);
    public static final UIElementID VOICE_PLAYERS_SETTINGS = new UIElementID("VOICE_PLAYERS_SETTINGS", 2, 3, ProjectType.COMMON);
    public static final UIElementID DIALOG = new UIElementID("DIALOG", 3, 4, ProjectType.COMMON);
    public static final UIElementID RADIAL_MENU = new UIElementID("RADIAL_MENU", 4, 5, ProjectType.COMMON);
    public static final UIElementID SNACKBAR = new UIElementID("SNACKBAR", 5, 6, ProjectType.COMMON);
    public static final UIElementID ANIMATION_MENU = new UIElementID("ANIMATION_MENU", 6, 7, ProjectType.COMMON);
    public static final UIElementID HUD = new UIElementID("HUD", 7, 8, ProjectType.COMMON);
    public static final UIElementID AUTHORIZATION = new UIElementID("AUTHORIZATION", 8, 9, ProjectType.COMMON);
    public static final UIElementID RODINA_SELECT_CHARACTER = new UIElementID("RODINA_SELECT_CHARACTER", 9, 10, ProjectType.RODINA);
    public static final UIElementID RODINA_PARK_MENU = new UIElementID("RODINA_PARK_MENU", 10, 11, ProjectType.RODINA);
    public static final UIElementID RODINA_VEHICLE_DOCUMENT = new UIElementID("RODINA_VEHICLE_DOCUMENT", 11, 12, ProjectType.RODINA);
    public static final UIElementID RODINA_REGISTRATION_REFERRAL = new UIElementID("RODINA_REGISTRATION_REFERRAL", 12, 13, ProjectType.RODINA);
    public static final UIElementID RODINA_REFERRAL = new UIElementID("RODINA_REFERRAL", 13, 14, ProjectType.RODINA);
    public static final UIElementID QUEST_DIALOG = new UIElementID("QUEST_DIALOG", 14, 15, ProjectType.COMMON);
    public static final UIElementID RODINA_CAPTURE = new UIElementID("RODINA_CAPTURE", 15, 16, ProjectType.RODINA);
    public static final UIElementID PERSONAL_PROPERTY = new UIElementID("PERSONAL_PROPERTY", 16, 17, ProjectType.COMMON);
    public static final UIElementID RODINA_EMPLOYMENT_CENTER = new UIElementID("RODINA_EMPLOYMENT_CENTER", 17, 18, ProjectType.RODINA);
    public static final UIElementID RODINA_SHOP_SCREEN = new UIElementID("RODINA_SHOP_SCREEN", 18, 19, ProjectType.RODINA);
    public static final UIElementID RODINA_VEHICLE_LIST = new UIElementID("RODINA_VEHICLE_LIST", 19, 20, ProjectType.RODINA);
    public static final UIElementID RODINA_METAL_DETECTOR = new UIElementID("RODINA_METAL_DETECTOR", 20, 21, ProjectType.COMMON);
    public static final UIElementID RODINA_JOB_MAIN_SCREEN = new UIElementID("RODINA_JOB_MAIN_SCREEN", 21, 22, ProjectType.RODINA);
    public static final UIElementID RODINA_JOB_RATING_SCREEN = new UIElementID("RODINA_JOB_RATING_SCREEN", 22, 23, ProjectType.RODINA);
    public static final UIElementID RODINA_JOB_CONTRACTS_SCREEN = new UIElementID("RODINA_JOB_CONTRACTS_SCREEN", 23, 24, ProjectType.RODINA);
    public static final UIElementID UNIVERSAL_ACTION = new UIElementID("UNIVERSAL_ACTION", 24, 25, ProjectType.COMMON);
    public static final UIElementID RODINA_CONTAINER_SCREEN = new UIElementID("RODINA_CONTAINER_SCREEN", 25, 26, ProjectType.RODINA);
    public static final UIElementID RODINA_LATCHKEY_SCREEN = new UIElementID("RODINA_LATCHKEY_SCREEN", 26, 27, ProjectType.RODINA);
    public static final UIElementID RODINA_EXCAVATION_SCREEN = new UIElementID("RODINA_EXCAVATION_SCREEN", 27, 28, ProjectType.COMMON);
    public static final UIElementID QUESTS_SCREEN = new UIElementID("QUESTS_SCREEN", 28, 29, ProjectType.COMMON);
    public static final UIElementID RODINA_LICENSE_PLATES_SCREEN = new UIElementID("RODINA_LICENSE_PLATES_SCREEN", 29, 30, ProjectType.RODINA);
    public static final UIElementID RODINA_SERVICE_STATION = new UIElementID("RODINA_SERVICE_STATION", 30, 31, ProjectType.RODINA);
    public static final UIElementID RODINA_MOBILE_PHONE = new UIElementID("RODINA_MOBILE_PHONE", 31, 32, ProjectType.RODINA);
    public static final UIElementID DICE_SCREEN = new UIElementID("DICE_SCREEN", 32, 33, ProjectType.COMMON);
    public static final UIElementID RODINA_UNIVERSAL_MENU = new UIElementID("RODINA_UNIVERSAL_MENU", 33, 34, ProjectType.RODINA);
    public static final UIElementID RODINA_DRIFT_SCORE_SCREEN = new UIElementID("RODINA_DRIFT_SCORE_SCREEN", 34, 35, ProjectType.RODINA);
    public static final UIElementID RODINA_CAPTCHA_SCREEN = new UIElementID("RODINA_CAPTCHA_SCREEN", 35, 37, ProjectType.RODINA);
    public static final UIElementID ARIZONA_PASS_PROMO = new UIElementID("ARIZONA_PASS_PROMO", 36, 38, ProjectType.ARIZONA);
    public static final UIElementID USER_BATTLE_PASS = new UIElementID("USER_BATTLE_PASS", 37, 39, ProjectType.COMMON);
    public static final UIElementID MAIN_BATTLE_PASS = new UIElementID("MAIN_BATTLE_PASS", 38, 40, ProjectType.COMMON);
    public static final UIElementID NEWBIE_BATTLE_PASS = new UIElementID("NEWBIE_BATTLE_PASS", 39, 41, ProjectType.COMMON);
    public static final UIElementID ARIZONA_DONATE_SHOP = new UIElementID("ARIZONA_DONATE_SHOP", 40, 42, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_CONTAINER = new UIElementID("ARIZONA_CONTAINER", 41, 43, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_CURRENT_CONTAINER = new UIElementID("ARIZONA_CURRENT_CONTAINER", 42, 44, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_CONTAINER_REWARDS = new UIElementID("ARIZONA_CONTAINER_REWARDS", 43, 45, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_ACTION = new UIElementID("ARIZONA_ACTION", 44, 46, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_MOBILE_PHONE = new UIElementID("ARIZONA_MOBILE_PHONE", 45, 47, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_GAS_STATION = new UIElementID("ARIZONA_GAS_STATION", 46, 48, ProjectType.COMMON);
    public static final UIElementID CINEMA_EFFECT = new UIElementID("CINEMA_EFFECT", 47, 49, ProjectType.COMMON);
    public static final UIElementID RODINA_NEW_QUEST = new UIElementID("RODINA_NEW_QUEST", 48, 50, ProjectType.COMMON);
    public static final UIElementID ARIZONA_VEHICLE_PLATE = new UIElementID("ARIZONA_VEHICLE_PLATE", 49, 51, ProjectType.ARIZONA);
    public static final UIElementID INVENTORY = new UIElementID("INVENTORY", 50, 52, ProjectType.COMMON);
    public static final UIElementID INTERACTION_BUTTON = new UIElementID("INTERACTION_BUTTON", 51, 53, ProjectType.COMMON);
    public static final UIElementID MAIN_MENU = new UIElementID("MAIN_MENU", 52, 54, ProjectType.COMMON);
    public static final UIElementID ARIZONA_STREET_FOOD = new UIElementID("ARIZONA_STREET_FOOD", 53, 55, ProjectType.COMMON);
    public static final UIElementID PLAYER_LIST = new UIElementID("PLAYER_LIST", 54, 56, ProjectType.COMMON);
    public static final UIElementID TRADE = new UIElementID("TRADE", 55, 57, ProjectType.COMMON);
    public static final UIElementID CRAFT = new UIElementID("CRAFT", 56, 58, ProjectType.COMMON);
    public static final UIElementID WORKSHOP = new UIElementID("WORKSHOP", 57, 59, ProjectType.COMMON);
    public static final UIElementID ARIZONA_GLOVO = new UIElementID("ARIZONA_GLOVO", 58, 60, ProjectType.COMMON);
    public static final UIElementID ARIZONA_LAVKA = new UIElementID("ARIZONA_LAVKA", 59, 61, ProjectType.COMMON);
    public static final UIElementID INPUT_LAYOUT = new UIElementID("INPUT_LAYOUT", 60, 62, ProjectType.COMMON);
    public static final UIElementID STREAM_VIDEO = new UIElementID("STREAM_VIDEO", 61, 63, ProjectType.COMMON);
    public static final UIElementID INVENTORY_SECURITY_SCREEN = new UIElementID("INVENTORY_SECURITY_SCREEN", 62, 64, ProjectType.COMMON);
    public static final UIElementID INVENTORY_WAREHOUSE = new UIElementID("INVENTORY_WAREHOUSE", 63, 65, ProjectType.COMMON);
    public static final UIElementID INVENTORY_VEHICLE_SCREEN = new UIElementID("INVENTORY_VEHICLE_SCREEN", 64, 66, ProjectType.COMMON);
    public static final UIElementID INVENTORY_WALLET_SCREEN = new UIElementID("INVENTORY_WALLET_SCREEN", 65, 67, ProjectType.COMMON);
    public static final UIElementID PRODUCTS_SCREEN = new UIElementID("PRODUCTS_SCREEN", 66, 68, ProjectType.COMMON);
    public static final UIElementID RODINA_CHOOSE_INTERIOR = new UIElementID("RODINA_CHOOSE_INTERIOR", 67, 69, ProjectType.RODINA);
    public static final UIElementID RODINA_UPGRADE_HOME = new UIElementID("RODINA_UPGRADE_HOME", 68, 70, ProjectType.RODINA);
    public static final UIElementID PREVIEW_USER_INVENTORY = new UIElementID("PREVIEW_USER_INVENTORY", 69, 72, ProjectType.COMMON);
    public static final UIElementID VIDEO_ADVICE = new UIElementID("VIDEO_ADVICE", 70, 73, ProjectType.COMMON);
    public static final UIElementID TUNING_SCREEN = new UIElementID("TUNING_SCREEN", 71, 74, ProjectType.COMMON);
    public static final UIElementID EMPLOYMENT_TASK = new UIElementID("EMPLOYMENT_TASK", 72, 75, ProjectType.COMMON);
    public static final UIElementID CASE_ROULETTE = new UIElementID("CASE_ROULETTE", 73, 76, ProjectType.COMMON);
    public static final UIElementID FLASH_GRENADE = new UIElementID("FLASH_GRENADE", 74, 77, ProjectType.COMMON);
    public static final UIElementID SHOOTING_GALLERY = new UIElementID("SHOOTING_GALLERY", 75, 78, ProjectType.RODINA);
    public static final UIElementID FRACTION_STAT = new UIElementID("FRACTION_STAT", 76, 79, ProjectType.RODINA);
    public static final UIElementID ARIZONA_SITUATION = new UIElementID("ARIZONA_SITUATION", 77, 80, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_FISHING = new UIElementID("ARIZONA_FISHING", 78, 81, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_NEW_CONTAINER = new UIElementID("ARIZONA_NEW_CONTAINER", 79, 82, ProjectType.ARIZONA);
    public static final UIElementID ARIZONA_BANNERS = new UIElementID("ARIZONA_BANNERS", 80, 83, ProjectType.COMMON);
    public static final UIElementID ARIZONA_BUSINESS = new UIElementID("ARIZONA_BUSINESS", 81, 84, ProjectType.ARIZONA);
    public static final UIElementID TRAIN_JOB = new UIElementID("TRAIN_JOB", 82, 85, ProjectType.RODINA);
    public static final UIElementID COLLECTOR_JOB = new UIElementID("COLLECTOR_JOB", 83, 86, ProjectType.RODINA);
    public static final UIElementID HINTS = new UIElementID("HINTS", 84, 87, ProjectType.COMMON);
    public static final UIElementID DAILY_REWARD = new UIElementID("DAILY_REWARD", 85, 88, ProjectType.COMMON);
    public static final UIElementID LINKING = new UIElementID("LINKING", 86, 89, ProjectType.COMMON);
    public static final UIElementID SKILLS = new UIElementID("SKILLS", 87, 90, ProjectType.RODINA);
    public static final UIElementID CARS = new UIElementID("CARS", 88, 91, ProjectType.ARIZONA);
    public static final UIElementID HOUSES = new UIElementID("HOUSES", 89, 94, ProjectType.ARIZONA);
    public static final UIElementID POTIONS = new UIElementID("POTIONS", 90, 95, ProjectType.COMMON);
    public static final UIElementID CASINO = new UIElementID("CASINO", 91, 96, ProjectType.COMMON);
    public static final UIElementID REWARDS_SCREEN = new UIElementID("REWARDS_SCREEN", 92, 97, ProjectType.COMMON);
    public static final UIElementID BLUEPRINT = new UIElementID("BLUEPRINT", 93, 98, ProjectType.COMMON);
    public static final UIElementID BATTLE_PASS = new UIElementID("BATTLE_PASS", 94, 99, ProjectType.COMMON);
    public static final UIElementID CATALOG = new UIElementID("CATALOG", 95, 101, ProjectType.COMMON);
    public static final UIElementID NEIGHBOR_GAME_TASK = new UIElementID("NEIGHBOR_GAME_TASK", 96, 102, ProjectType.RODINA);
    public static final UIElementID NEIGHBOR_GAME = new UIElementID("NEIGHBOR_GAME", 97, 103, ProjectType.RODINA);
    public static final UIElementID ARIZONA_DOCUMENTS = new UIElementID("ARIZONA_DOCUMENTS", 98, 104, ProjectType.ARIZONA);
    public static final UIElementID GROOMING = new UIElementID("GROOMING", 99, 107, ProjectType.RODINA);
    public static final UIElementID AGREEMENT_SCREEN = new UIElementID("AGREEMENT_SCREEN", 100, 108, ProjectType.RODINA);
    public static final UIElementID FAMILY_RODINA = new UIElementID("FAMILY_RODINA", 101, 109, ProjectType.RODINA);
    public static final UIElementID EASTER_MENU = new UIElementID("EASTER_MENU", 102, 110, ProjectType.COMMON);
    public static final UIElementID BP_EVENT_CHOICE = new UIElementID("BP_EVENT_CHOICE", 103, 111, ProjectType.COMMON);
    public static final UIElementID CONVEYOR_GAME = new UIElementID("CONVEYOR_GAME", 104, 112, ProjectType.COMMON);
    public static final UIElementID IMPROVEMENT_PREMIUM_VIP = new UIElementID("IMPROVEMENT_PREMIUM_VIP", 105, 113, ProjectType.RODINA);
    public static final UIElementID CASES = new UIElementID("CASES", 106, 114, ProjectType.RODINA);
    public static final UIElementID FAMILY_ARIZONA = new UIElementID("FAMILY_ARIZONA", 107, BuildConfig.API_LEVEL, ProjectType.ARIZONA);
    public static final UIElementID STARTER_PACK_RODINA = new UIElementID("STARTER_PACK_RODINA", 108, AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, ProjectType.RODINA);

    private static final /* synthetic */ UIElementID[] $values() {
        return new UIElementID[]{COMMAND_BINDER, VOICE_SETTINGS, VOICE_PLAYERS_SETTINGS, DIALOG, RADIAL_MENU, SNACKBAR, ANIMATION_MENU, HUD, AUTHORIZATION, RODINA_SELECT_CHARACTER, RODINA_PARK_MENU, RODINA_VEHICLE_DOCUMENT, RODINA_REGISTRATION_REFERRAL, RODINA_REFERRAL, QUEST_DIALOG, RODINA_CAPTURE, PERSONAL_PROPERTY, RODINA_EMPLOYMENT_CENTER, RODINA_SHOP_SCREEN, RODINA_VEHICLE_LIST, RODINA_METAL_DETECTOR, RODINA_JOB_MAIN_SCREEN, RODINA_JOB_RATING_SCREEN, RODINA_JOB_CONTRACTS_SCREEN, UNIVERSAL_ACTION, RODINA_CONTAINER_SCREEN, RODINA_LATCHKEY_SCREEN, RODINA_EXCAVATION_SCREEN, QUESTS_SCREEN, RODINA_LICENSE_PLATES_SCREEN, RODINA_SERVICE_STATION, RODINA_MOBILE_PHONE, DICE_SCREEN, RODINA_UNIVERSAL_MENU, RODINA_DRIFT_SCORE_SCREEN, RODINA_CAPTCHA_SCREEN, ARIZONA_PASS_PROMO, USER_BATTLE_PASS, MAIN_BATTLE_PASS, NEWBIE_BATTLE_PASS, ARIZONA_DONATE_SHOP, ARIZONA_CONTAINER, ARIZONA_CURRENT_CONTAINER, ARIZONA_CONTAINER_REWARDS, ARIZONA_ACTION, ARIZONA_MOBILE_PHONE, ARIZONA_GAS_STATION, CINEMA_EFFECT, RODINA_NEW_QUEST, ARIZONA_VEHICLE_PLATE, INVENTORY, INTERACTION_BUTTON, MAIN_MENU, ARIZONA_STREET_FOOD, PLAYER_LIST, TRADE, CRAFT, WORKSHOP, ARIZONA_GLOVO, ARIZONA_LAVKA, INPUT_LAYOUT, STREAM_VIDEO, INVENTORY_SECURITY_SCREEN, INVENTORY_WAREHOUSE, INVENTORY_VEHICLE_SCREEN, INVENTORY_WALLET_SCREEN, PRODUCTS_SCREEN, RODINA_CHOOSE_INTERIOR, RODINA_UPGRADE_HOME, PREVIEW_USER_INVENTORY, VIDEO_ADVICE, TUNING_SCREEN, EMPLOYMENT_TASK, CASE_ROULETTE, FLASH_GRENADE, SHOOTING_GALLERY, FRACTION_STAT, ARIZONA_SITUATION, ARIZONA_FISHING, ARIZONA_NEW_CONTAINER, ARIZONA_BANNERS, ARIZONA_BUSINESS, TRAIN_JOB, COLLECTOR_JOB, HINTS, DAILY_REWARD, LINKING, SKILLS, CARS, HOUSES, POTIONS, CASINO, REWARDS_SCREEN, BLUEPRINT, BATTLE_PASS, CATALOG, NEIGHBOR_GAME_TASK, NEIGHBOR_GAME, ARIZONA_DOCUMENTS, GROOMING, AGREEMENT_SCREEN, FAMILY_RODINA, EASTER_MENU, BP_EVENT_CHOICE, CONVEYOR_GAME, IMPROVEMENT_PREMIUM_VIP, CASES, FAMILY_ARIZONA, STARTER_PACK_RODINA};
    }

    public static EnumEntries<UIElementID> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final int getLastUIElementID() {
        return Companion.getLastUIElementID();
    }

    @JvmStatic
    public static final UIElementID getUIElementID(int i, ProjectType projectType) {
        return Companion.getUIElementID(i, projectType);
    }

    private UIElementID(String str, int i, int i2, ProjectType projectType) {
        this.id = i2;
        this.projectType = projectType;
    }

    public final int getId() {
        return this.id;
    }

    public final ProjectType getProjectType() {
        return this.projectType;
    }

    static {
        UIElementID[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: UIElementID.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/core/UIElementID$Companion;", "", "<init>", "()V", "getUIElementID", "Lru/mrlargha/commonui/core/UIElementID;", "id", "", "projectType", "Lru/mrlargha/commonui/core/ProjectType;", "getLastUIElementID", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UIElementID getUIElementID(int i, ProjectType projectType) {
            Intrinsics.checkNotNullParameter(projectType, "projectType");
            for (UIElementID uIElementID : UIElementID.getEntries()) {
                if (uIElementID.getId() == i && (uIElementID.getProjectType() == projectType || uIElementID.getProjectType() == ProjectType.COMMON)) {
                    return uIElementID;
                }
            }
            throw new IllegalArgumentException("Invalid UI Element ID: " + i + ", for project type: " + projectType);
        }

        @JvmStatic
        public final int getLastUIElementID() {
            return ((UIElementID) UIElementID.getEntries().get(UIElementID.getEntries().size() - 1)).getId() + 1;
        }
    }

    public static UIElementID valueOf(String str) {
        return (UIElementID) Enum.valueOf(UIElementID.class, str);
    }

    public static UIElementID[] values() {
        return (UIElementID[]) $VALUES.clone();
    }
}
