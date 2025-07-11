package com.google.android.gms.internal.measurement;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.adjust.sdk.Constants;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzpa implements zzoz {
    public static final zzkl zzA;
    public static final zzkl zzB;
    public static final zzkl zzC;
    public static final zzkl zzD;
    public static final zzkl zzE;
    public static final zzkl zzF;
    public static final zzkl zzG;
    public static final zzkl zzH;
    public static final zzkl zzI;
    public static final zzkl zzJ;
    public static final zzkl zzK;
    public static final zzkl zzL;
    public static final zzkl zzM;
    public static final zzkl zzN;
    public static final zzkl zzO;
    public static final zzkl zzP;
    public static final zzkl zzQ;
    public static final zzkl zzR;
    public static final zzkl zzS;
    public static final zzkl zzT;
    public static final zzkl zzU;
    public static final zzkl zzV;
    public static final zzkl zzW;
    public static final zzkl zzX;
    public static final zzkl zzY;
    public static final zzkl zzZ;
    public static final zzkl zza;
    public static final zzkl zzaa;
    public static final zzkl zzab;
    public static final zzkl zzac;
    public static final zzkl zzad;
    public static final zzkl zzae;
    public static final zzkl zzaf;
    public static final zzkl zzag;
    public static final zzkl zzah;
    public static final zzkl zzai;
    public static final zzkl zzaj;
    public static final zzkl zzak;
    public static final zzkl zzal;
    public static final zzkl zzam;
    public static final zzkl zzan;
    public static final zzkl zzao;
    public static final zzkl zzap;
    public static final zzkl zzaq;
    public static final zzkl zzar;
    public static final zzkl zzas;
    public static final zzkl zzat;
    public static final zzkl zzau;
    public static final zzkl zzav;
    public static final zzkl zzaw;
    public static final zzkl zzb;
    public static final zzkl zzc;
    public static final zzkl zzd;
    public static final zzkl zze;
    public static final zzkl zzf;
    public static final zzkl zzg;
    public static final zzkl zzh;
    public static final zzkl zzi;
    public static final zzkl zzj;
    public static final zzkl zzk;
    public static final zzkl zzl;
    public static final zzkl zzm;
    public static final zzkl zzn;
    public static final zzkl zzo;
    public static final zzkl zzp;
    public static final zzkl zzq;
    public static final zzkl zzr;
    public static final zzkl zzs;
    public static final zzkl zzt;
    public static final zzkl zzu;
    public static final zzkl zzv;
    public static final zzkl zzw;
    public static final zzkl zzx;
    public static final zzkl zzy;
    public static final zzkl zzz;

    static {
        zzkf zzb2 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb2.zzc("measurement.ad_id_cache_time", Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
        zzb = zzb2.zzc("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        zzc = zzb2.zzd("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        zzd = zzb2.zzc("measurement.max_bundles_per_iteration", 100L);
        zze = zzb2.zzf("measurement.gbraid_campaign.campaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid");
        zzf = zzb2.zzc("measurement.config.cache_time", CalendarModelKt.MillisecondsIn24Hours);
        zzb2.zzf("measurement.log_tag", "FA");
        zzg = zzb2.zzf("measurement.config.url_authority", "app-measurement.com");
        zzh = zzb2.zzf("measurement.config.url_scheme", Constants.SCHEME);
        zzi = zzb2.zzc("measurement.upload.debug_upload_interval", 1000L);
        zzb2.zzd("measurement.config.default_flag_values", true);
        zzj = zzb2.zzc("measurement.session.engagement_interval", 3600000L);
        zzk = zzb2.zzf("measurement.rb.attribution.event_params", "value|currency");
        zzl = zzb2.zzf("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp");
        zzm = zzb2.zzc("measurement.upload.google_signal_max_queue_time", 605000L);
        zzn = zzb2.zzf("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        zzo = zzb2.zzc("measurement.lifetimevalue.max_currency_tracked", 4L);
        zzp = zzb2.zzc("measurement.dma_consent.max_daily_dcu_realtime_events", 1L);
        zzq = zzb2.zzc("measurement.upload.max_event_parameter_value_length", 500L);
        zzr = zzb2.zzc("measurement.store.max_stored_events_per_app", SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US);
        zzs = zzb2.zzc("measurement.experiment.max_ids", 50L);
        zzt = zzb2.zzc("measurement.audience.filter_result_max_count", 200L);
        zzu = zzb2.zzc("measurement.upload.max_item_scoped_custom_parameters", 27L);
        zzv = zzb2.zzc("measurement.rb.max_trigger_registrations_per_day", 1000L);
        zzw = zzb2.zzc("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0L);
        zzx = zzb2.zzc("measurement.rb.attribution.client.min_ad_services_version", 7L);
        zzy = zzb2.zzc("measurement.alarm_manager.minimum_interval", 60000L);
        zzz = zzb2.zzc("measurement.upload.minimum_delay", 500L);
        zzA = zzb2.zzc("measurement.monitoring.sample_period_millis", CalendarModelKt.MillisecondsIn24Hours);
        zzB = zzb2.zzc("measurement.rb.attribution.notify_app_delay_millis", C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        zzC = zzb2.zzd("measurement.config.notify_trigger_uris_on_backgrounded", true);
        zzb2.zzc("measurement.id.rb.attribution.app_allowlist", 0L);
        zzD = zzb2.zzf("measurement.rb.attribution.app_allowlist", "com.labpixies.flood");
        zzE = zzb2.zzc("measurement.upload.realtime_upload_interval", Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
        zzF = zzb2.zzc("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        zzb2.zzc("measurement.config.cache_time.service", 3600000L);
        zzG = zzb2.zzc("measurement.service_client.idle_disconnect_millis", 5000L);
        zzb2.zzf("measurement.log_tag.service", "FA-SVC");
        zzH = zzb2.zzc("measurement.service_client.reconnect_millis", 1000L);
        zzb2.zzf("measurement.sgtm.app_allowlist", "*");
        zzI = zzb2.zzc("measurement.sgtm.batch.long_queuing_threshold", 240000L);
        zzJ = zzb2.zzc("measurement.sgtm.batch.retry_interval", 1800000L);
        zzK = zzb2.zzc("measurement.sgtm.batch.retry_max_count", 10L);
        zzL = zzb2.zzc("measurement.sgtm.batch.retry_max_wait", 21600000L);
        zzM = zzb2.zzf("measurement.sgtm.service_upload_apps_list", "");
        zzN = zzb2.zzf("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        zzO = zzb2.zzc("measurement.sgtm.upload.batches_retrieval_limit", 5L);
        zzP = zzb2.zzc("measurement.sgtm.upload.max_queued_batches", 5000L);
        zzQ = zzb2.zzc("measurement.sgtm.upload.min_delay_after_background", 600000L);
        zzR = zzb2.zzc("measurement.sgtm.upload.min_delay_after_broadcast", 1000L);
        zzS = zzb2.zzc("measurement.sgtm.upload.min_delay_after_startup", 5000L);
        zzT = zzb2.zzc("measurement.sgtm.upload.retry_interval", 600000L);
        zzU = zzb2.zzc("measurement.sgtm.upload.retry_max_wait", 21600000L);
        zzV = zzb2.zzc("measurement.upload.stale_data_deletion_interval", CalendarModelKt.MillisecondsIn24Hours);
        zzW = zzb2.zzc("measurement.rb.attribution.max_retry_delay_seconds", 16L);
        zzX = zzb2.zzc("measurement.rb.attribution.client.min_time_after_boot_seconds", 90L);
        zzY = zzb2.zzf("measurement.rb.attribution.uri_authority", "google-analytics.com");
        zzZ = zzb2.zzc("measurement.rb.attribution.max_queue_time", 864000000L);
        zzaa = zzb2.zzf("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        zzab = zzb2.zzf("measurement.rb.attribution.query_parameters_to_remove", "");
        zzac = zzb2.zzf("measurement.rb.attribution.uri_scheme", Constants.SCHEME);
        zzad = zzb2.zzc("measurement.sdk.attribution.cache.ttl", 604800000L);
        zzae = zzb2.zzc("measurement.redaction.app_instance_id.ttl", 7200000L);
        zzaf = zzb2.zzc("measurement.upload.backoff_period", 43200000L);
        zzag = zzb2.zzc("measurement.upload.initial_upload_delay_time", 15000L);
        zzah = zzb2.zzc("measurement.upload.interval", 3600000L);
        zzai = zzb2.zzc("measurement.upload.max_bundle_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzaj = zzb2.zzc("measurement.upload.max_bundles", 100L);
        zzak = zzb2.zzc("measurement.upload.max_conversions_per_day", 500L);
        zzal = zzb2.zzc("measurement.upload.max_error_events_per_day", 1000L);
        zzam = zzb2.zzc("measurement.upload.max_events_per_bundle", 1000L);
        zzan = zzb2.zzc("measurement.upload.max_events_per_day", SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US);
        zzao = zzb2.zzc("measurement.upload.max_public_events_per_day", 50000L);
        zzap = zzb2.zzc("measurement.upload.max_queue_time", 518400000L);
        zzaq = zzb2.zzc("measurement.upload.max_realtime_events_per_day", 10L);
        zzar = zzb2.zzc("measurement.upload.max_batch_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzas = zzb2.zzc("measurement.upload.retry_count", 6L);
        zzat = zzb2.zzc("measurement.upload.retry_time", 1800000L);
        zzau = zzb2.zzf("measurement.upload.url", "https://app-measurement.com/a");
        zzav = zzb2.zzc("measurement.upload.window_interval", 3600000L);
        zzaw = zzb2.zzf("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzA() {
        return ((Long) zzA.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzB() {
        return ((Long) zzB.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final boolean zzC() {
        return ((Boolean) zzC.zzd()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzD() {
        return (String) zzD.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzE() {
        return ((Long) zzE.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzF() {
        return ((Long) zzF.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzG() {
        return ((Long) zzG.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzH() {
        return ((Long) zzH.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzI() {
        return ((Long) zzI.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzJ() {
        return ((Long) zzJ.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzK() {
        return ((Long) zzK.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzL() {
        return ((Long) zzL.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzM() {
        return (String) zzM.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzN() {
        return (String) zzN.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzO() {
        return ((Long) zzO.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzP() {
        return ((Long) zzP.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzQ() {
        return ((Long) zzQ.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzR() {
        return ((Long) zzR.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzS() {
        return ((Long) zzS.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzT() {
        return ((Long) zzT.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzU() {
        return ((Long) zzU.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzV() {
        return ((Long) zzV.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzW() {
        return ((Long) zzW.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzX() {
        return ((Long) zzX.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzY() {
        return (String) zzY.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzZ() {
        return ((Long) zzZ.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zza() {
        return ((Long) zza.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzaa() {
        return (String) zzaa.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzab() {
        return (String) zzab.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzac() {
        return (String) zzac.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzad() {
        return ((Long) zzad.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzae() {
        return ((Long) zzae.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzaf() {
        return ((Long) zzaf.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzag() {
        return ((Long) zzag.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzah() {
        return ((Long) zzah.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzai() {
        return ((Long) zzai.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzaj() {
        return ((Long) zzaj.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzak() {
        return ((Long) zzak.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzal() {
        return ((Long) zzal.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzam() {
        return ((Long) zzam.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzan() {
        return ((Long) zzan.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzao() {
        return ((Long) zzao.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzap() {
        return ((Long) zzap.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzaq() {
        return ((Long) zzaq.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzar() {
        return ((Long) zzar.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzas() {
        return ((Long) zzas.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzat() {
        return ((Long) zzat.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzau() {
        return (String) zzau.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzav() {
        return ((Long) zzav.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzaw() {
        return (String) zzaw.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzb() {
        return ((Long) zzb.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final boolean zzc() {
        return ((Boolean) zzc.zzd()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzd() {
        return ((Long) zzd.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zze() {
        return (String) zze.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzf() {
        return ((Long) zzf.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzg() {
        return (String) zzg.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzh() {
        return (String) zzh.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzi() {
        return ((Long) zzi.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzj() {
        return ((Long) zzj.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzk() {
        return (String) zzk.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzl() {
        return (String) zzl.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzm() {
        return ((Long) zzm.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzn() {
        return (String) zzn.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzo() {
        return ((Long) zzo.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzp() {
        return ((Long) zzp.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzq() {
        return ((Long) zzq.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzr() {
        return ((Long) zzr.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzs() {
        return ((Long) zzs.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzt() {
        return ((Long) zzt.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzu() {
        return ((Long) zzu.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzv() {
        return ((Long) zzv.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzw() {
        return ((Long) zzw.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzx() {
        return ((Long) zzx.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzy() {
        return ((Long) zzy.zzd()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzz() {
        return ((Long) zzz.zzd()).longValue();
    }
}
