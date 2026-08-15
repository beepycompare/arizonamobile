package com.arizona.launcher;

import kotlin.Metadata;
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/UpdateAnalyticsContract;", "", "<init>", "()V", "DOWNLOAD_ERROR_EVENT", "", "DOWNLOAD_ERROR_FIRST_LAUNCH_EVENT", "DOWNLOAD_RETRY_EVENT", "LEGACY_CALL_SITE_PARAM", "SOURCE_LINE_PARAM", "ERROR_CODE_PARAM", "ERROR_TYPE_PARAM", "ERROR_SUBTYPE_PARAM", "HTTP_STATUS_PARAM", "ERROR_CONTEXT_PARAM", "ERRNO_PARAM", "ERRNO_CODE_PARAM", "ERRNO_NAME_PARAM", "EVENT_TAG_PARAM", "FIRST_LAUNCH_PARAM", "FIRST_LAUNCH_DEDUPED_PARAM", "SERVER_HOST_PARAM", "NETWORK_INTERNET_CAPABLE_PARAM", "NETWORK_VALIDATED_PARAM", "RETRY_STAGE_PARAM", "RETRY_ATTEMPT_PARAM", "RETRY_DELAY_MS_PARAM", "ARCHIVE_PACKAGE_ID_PARAM", "FIRST_LAUNCH_EVENT_TAG", "ARCHIVE_INDEX_RETRY_STAGE", "ARCHIVE_PACKAGE_RETRY_STAGE", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateAnalyticsContract {
    public static final int $stable = 0;
    public static final String ARCHIVE_INDEX_RETRY_STAGE = "archive_index";
    public static final String ARCHIVE_PACKAGE_ID_PARAM = "archive_package_id";
    public static final String ARCHIVE_PACKAGE_RETRY_STAGE = "archive_package";
    public static final String DOWNLOAD_ERROR_EVENT = "error_download";
    public static final String DOWNLOAD_ERROR_FIRST_LAUNCH_EVENT = "error_download_first_launch";
    public static final String DOWNLOAD_RETRY_EVENT = "download_retry";
    public static final String ERRNO_CODE_PARAM = "errno_code";
    public static final String ERRNO_NAME_PARAM = "errno_name";
    public static final String ERRNO_PARAM = "errno";
    public static final String ERROR_CODE_PARAM = "error_code";
    public static final String ERROR_CONTEXT_PARAM = "error_context";
    public static final String ERROR_SUBTYPE_PARAM = "error_subtype";
    public static final String ERROR_TYPE_PARAM = "error_type";
    public static final String EVENT_TAG_PARAM = "event_tag";
    public static final String FIRST_LAUNCH_DEDUPED_PARAM = "first_launch_deduped";
    public static final String FIRST_LAUNCH_EVENT_TAG = "first_launch";
    public static final String FIRST_LAUNCH_PARAM = "first_launch";
    public static final String HTTP_STATUS_PARAM = "http_status";
    public static final UpdateAnalyticsContract INSTANCE = new UpdateAnalyticsContract();
    public static final String LEGACY_CALL_SITE_PARAM = ".kt";
    public static final String NETWORK_INTERNET_CAPABLE_PARAM = "network_internet_capable";
    public static final String NETWORK_VALIDATED_PARAM = "network_validated";
    public static final String RETRY_ATTEMPT_PARAM = "retry_attempt";
    public static final String RETRY_DELAY_MS_PARAM = "retry_delay_ms";
    public static final String RETRY_STAGE_PARAM = "retry_stage";
    public static final String SERVER_HOST_PARAM = "server_host";
    public static final String SOURCE_LINE_PARAM = "source_line";

    private UpdateAnalyticsContract() {
    }
}
