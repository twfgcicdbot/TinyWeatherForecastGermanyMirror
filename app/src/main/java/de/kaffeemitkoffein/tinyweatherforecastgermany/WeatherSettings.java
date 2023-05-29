/*
 * This file is part of TinyWeatherForecastGermany.
 *
 * Copyright (c) 2020, 2021, 2022, 2023 Pawel Dube
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.kaffeemitkoffein.tinyweatherforecastgermany;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.NOTIFICATION_SERVICE;

public class WeatherSettings {

    final static class NotificationIDRange {
        //  2147483601 to 2147483647 are reserved for other unique IDs
        final static int MIN = -2147483648;
        final static int MAX = 2147483600;
    }

    final static class StaticNotifationIDs {
        public static final int SERVICE_NOTIFICATION_IDENTIFIER = 2147483601;
    }

    final public static int[] NotificationLEDcolors =
                   {0xfff0e800,0xffffb300,0xffff5100,0xffff0000,
                    0xffa1ff00,0xff26ff00,0xff06ad00,0xff00ad9c,
                    0xff4dffed,0xff4daaff,0xff0073d1,0xff000899,
                    0xffff1f71,0xffd100a0,0xff8800a3,0xffdddddd};

    final static String FAVORITES_SEPERATOR = ";";

    public final static int DISPLAYTYPE_1HOUR = 1;
    public final static int DISPLAYTYPE_6HOURS = 3;
    public final static int DISPLAYTYPE_24HOURS = 4;
    public final static int DISPLAYTYPE_MIXED = 256;

    public static final String PREF_STATION_NAME = "PREF_station_name";
    public static final String PREF_LOCATION_DESCRIPTION = "PREF_station_description";
    public static final String PREF_LONGITUDE = "PREF_longitude";
    public static final String PREF_LATITUDE = "PREF_latitude";
    public static final String PREF_ALTITUDE = "PREF_altitude";
    public static final String PREF_STATIONTYPE = "PREF_stationtype";
    public static final String PREF_DISPLAY_STATION_GEO = "PREF_display_station_geo";
    public static final String PREF_DISPLAY_TYPE = "PREF_display_type";
    public static final String PREF_DISPLAY_LAYOUT = "PREF_display_layout";
    public static final String PREF_DISPLAY_BAR = "PREF_display_bar";
    public static final String PREF_DISPLAY_SIMPLE_BAR = "PREF_display_simple_bar";
    public static final String PREF_DISPLAY_PRESSURE = "PREF_display_pressure";
    public static final String PREF_DISPLAY_VISIBILITY = "PREF_display_visibility";
    public static final String PREF_DISPLAY_SUNRISE = "PREF_display_sunrise";
    public static final String PREF_DISPLAY_ENDOFDAY_BAR = "PREF_display_end_of_day_bar";
    public static final String PREF_DISPLAY_GRADIENT = "PREF_display_gradient";
    public static final String PREF_DISPLAY_WIND_ARC="PREF_display_wind_arc";
    public static final String PREF_DISPLAY_WIND_ARC_PERIOD="PREF_display_wind_arc_period";
    public static final String PREF_DISPLAY_WIND_TYPE = "PREF_display_wind_type";
    public static final String PREF_DISPLAY_WIND_UNIT = "PREF_display_wind_unit";
    public static final String PREF_DISPLAY_DISTANCE_UNIT = "PREF_display_distance_unit";
    public static final String PREF_DISPLAY_CROP_PRECIPITATIONCHART = "PREF_crop_precipchart";
    public static final String PREF_DISPLAY_OVERVIEWCHART = "PREF_display_overviewchart";
    public static final String PREF_DISPLAY_OVERVIEWCHART_DAYS="PREF_display_overviewchart_days";
    public static final String PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE = "PREF_display_overviewchart_mmu";
    public static final String PREF_DISPLAY_OVERVIEWCHART_MIN = "PREF_display_overviewchart_min";
    public static final String PREF_DISPLAY_OVERVIEWCHART_MAX = "PREF_display_overviewchart_max";
    public static final String PREF_SETALARM = "PREF_setalarm";
    public static final String PREF_UPDATEINTERVAL = "PREF_updateinterval";
    public static final String PREF_LASTWIDGETUPDATETIME = "PREF_lastwidgetupdatetime";
    public static final String PREF_UPDATE_WARNINGS = "PREF_update_warnings";
    public static final String PREF_UPDATE_TEXTFORECASTS = "PREF_update_textforecasts";
    public static final String PREF_WIDGET_OPACITY = "PREF_widget_opacity";
    public static final String PREF_WIDGET_SHOWDWDNOTE = "PREF_widget_showdwdnote";
    public static final String PREF_WIDGET_DISPLAYWARNINGS = "PREF_widget_displaywarnings";
    public static final String PREF_NOTIFY_WARNINGS = "PREF_notify_warnings";
    public static final String PREF_LAST_VERSION_CODE = "PREF_last_version_code";
    public static final String PREF_SERVE_GADGETBRIDGE = "PREF_serve_gadgetbridge";
    public static final String PREF_VIEWS_LAST_UPDATE_TIME = "PREF_views_last_update_time";
    public static final String PREF_GADGETBRIDGE_PACKAGENAME = "PREF_gadgetbridge_packagename";
    public static final String PREF_GADGETBRIDGE_FAKE_TIMESTAMP = "PREF_gadgetbridge_fake_timestamp";
    public static final String PREF_LOGGING = "PREF_logging";
    public static final String PREF_LOG_TO_LOGCAT = "PREF_log_to_logcat";
    public static final String PREF_FAVORITESDATA = "PREF_favoritesdata";
    public static final String PREF_WARNINGS_CACHETIME = "PREF_warnings_cachetime";
    public static final String PREF_WARNINGS_DISABLE = "PREF_warnings_diable";
    public static final String PREF_WARNINGS_LAST_UPDATE_TIME = "PREF_warnings_last_update_time";
    public static final String PREF_WARNINGS_NOTIFY_SEVERITY = "PREF_warnings_notify_severity";
    public static final String PREF_IS_FIRST_APP_LAUNCH = "PREF_is_first_app_launch";
    public static final String PREF_USEGPS = "PREF_usegps";
    public static final String PREF_GPSAUTO = "PREF_gpsauto";
    public static final String PREF_GPSMANUAL = "PREF_gpsmanual";
    public static final String PREF_LASTGPSFIX = "PREF_lastgpsfix";
    public static final String PREF_DISABLE_TLS = "PREF_disable_tls";
    public static final String PREF_TEXTFORECAST_LAST_UPDATE_TIME = "PREF_textforecast_last_update_time";
    public static final String PREF_TEXTFORECAST_FILTER = "PREF_textforecast_filter";
    public static final String PREF_RADAR_LASTDATAPOLL = "PREF_radar_lastdatapoll";
    public static final String PREF_RADAR_SHOW = "PREF_radar_show";
    public static final String PREF_ADMINMAP_SHOW="PREF_adminmap_show";
    public static final String PREF_MAP_DISPLAY_MUNICIPALITIES ="PREF_map_display_municipalities";
    public static final String PREF_MAP_DISPLAY_COUNTIES = "PREF_map_display_counties";
    public static final String PREF_MAP_DISPLAY_STATES = "PREF_map_display_states";
    public static final String PREF_MAP_DISPLAY_SEA_AREAS = "PREF_map_display_sea_areas";
    public static final String PREF_MAP_DISPLAY_COAST_AREAS = "PREF_map_display_coast_areas";
    public static final String PREF_FORCE_NO_MENU_ICONS = "PREF_force_nomenuicons";
    public static final String PREF_DISPLAY_WIND_IN_RADAR = "PREF_display_wind_in_radar";
    public static final String PREF_AREA_DATABASE_READY = "PREF_area_database_ready";
    public static final String PREF_AREA_DATABASE_VERSION = "PREF_area_database_version";
    public static final String PREF_VIEWMODEL = "PREF_viewmodel";
    public static final String PREF_THEME = "PREF_theme";
    public static final String PREF_ALTERNATIVE_ICONS = "PREF_alternative_icons";
    public static final String PREF_USE_METERED_NETWORKS = "PREF_use_metered_networks";
    public static final String PREF_NOTIFICATION_IDENTIFIER = "PREF_notification_id";
    public static final String PREF_CLEARNOTIFICATIONS = "PREF_clearnotifications";
    public static final String PREF_ASKEDFORLOCATIONPERMISSION = "PREF_askedlocpermission";
    public static final String PREF_ROTATIONMODE = "PREF_rotationmode";
    public static final String PREF_NC_CHANNEL_DETAIL = "PREF_channel_detail";
    public static final String PREF_LED_COLOR = "PREF_led_color";
    public static final String PREF_WARNINGS_NOTIFY_LED = "PREF_warnings_notify_LED";
    public static final String PREF_HINTCOUNTER1 = "PREF_hintcounter1";
    public static final String PREF_HINTCOUNTER2 = "PREF_hintcounter2";
    public static final String PREF_MAPLASTUPDATETIME = "PREF_maplastupdatetime";
    public static final String PREF_LASTMAPDISPLAYED = "PREF_lastmapdisplayed";

    public static final String PREF_STATION_NAME_DEFAULT = "P0489";
    public static final String PREF_LOCATION_DESCRIPTION_DEFAULT = "HAMBURG INNENSTADT";
    public static final double PREF_LATITUDE_DEFAULT = 53.55;
    public static final double PREF_LONGITUDE_DEFAULT = 9.98;
    public static final double PREF_ALTITUDE_DEFAULT = 8.0;
    public static final int PREF_STATIONTYPE_DEFAULT = RawWeatherInfo.Source.MOS;
    public static final boolean PREF_DISPLAY_STATION_GEO_DEFAULT = true;
    public static final String PREF_DISPLAY_TYPE_DEFAULT = "3";
    public static final String PREF_DISPLAY_LAYOUT_DEFAULT = "0";
    public static final boolean PREF_DISPLAY_BAR_DEFAULT = true;
    public static final boolean PREF_DISPLAY_SIMPLE_BAR_DEFAULT = false;
    public static final boolean PREF_DISPLAY_PRESSURE_DEFAULT = true;
    public static final boolean PREF_DISPLAY_VISIBILITY_DEFAULT = true;
    public static final boolean PREF_DISPLAY_SUNRISE_DEFAULT = true;
    public static final boolean PREF_DISPLAY_ENDOFDAY_BAR_DEFAULT = false;
    public static final boolean PREF_DISPLAY_GRADIENT_DEFAULT = false;
    public static final boolean PREF_DISPLAY_WIND_ARC_DEFAULT=false;
    public static final String PREF_DISPLAY_WIND_ARC_PERIOD_DEFAULT="6";
    public static final String PREF_DISPLAY_WIND_TYPE_DEFAULT = "0";
    public static final String PREF_DISPLAY_WIND_UNIT_DEFAULT = "0";
    public static final String PREF_DISPLAY_DISTANCE_UNIT_DEFAULT = "0";
    public static final boolean PREF_DISPLAY_CROP_PRECIPITATIONCHART_DEFAULT = false;
    public static final boolean PREF_DISPLAY_OVERVIEWCHART_DEFAULT = false;
    public static final int PREF_DISPLAY_OVERVIEWCHART_DAYS_DEFAULT = 10;
    public static final boolean PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE_DEFAULT = false;
    public static final int PREF_DISPLAY_OVERVIEWCHART_MIN_DEFAULT = 7;
    public static final int PREF_DISPLAY_OVERVIEWCHART_MAX_DEFAULT = 4;
    public static final boolean PREF_SETALARM_DEFAULT = true;
    public static final boolean PREF_UPDATE_WARNINGS_DEFAULT = true;
    public static final boolean PREF_UPDATE_TEXTFORECASTS_DEFAULT = true;
    public static final String PREF_UPDATEINTERVAL_DEFAULT = "24";
    public static final long PREF_LASTWIDGETUPDATETIME_DEFAULT = 0;
    public static final String PREF_WIDGET_OPACITY_DEFAULT = "90";
    public static final boolean PREF_WIDGET_SHOWDWDNOTE_DEFAULT = true;
    public static final boolean PREF_WIDGET_DISPLAYWARNINGS_DEFAULT = true;
    public static final boolean PREF_NOTIFY_WARNINGS_DEFAULT = true;
    public static final int PREF_LAST_VERSION_CODE_DEFAULT = 0;
    public static final boolean PREF_SERVE_GADGETBRIDGE_DEFAULT = false;
    public static final long PREF_VIEWS_LAST_UPDATE_TIME_DEFAULT = 0;
    public static final String PREF_GADGETBRIDGE_PACKAGENAME_DEFAULT = "nodomain.freeyourgadget.gadgetbridge";
    public static final boolean PREF_GADGETBRIDGE_FAKE_TIMESTAMP_DEFAULT = false;
    public static final boolean PREF_LOGGING_DEFAULT = false;
    public static final boolean PREF_LOG_TO_LOGCAT_DEFAULT = false;
    public static final String PREF_FAVORITESDATA_DEFAULT = PREF_STATION_NAME_DEFAULT;
    public static final String PREF_WARNINGS_CACHETIME_DEFAULT = "30";
    public static final boolean PREF_WARNINGS_DISABLE_DEFAULT = false;
    public static final long PREF_WARNINGS_LAST_UPDATE_TIME_DEFAULT = 0;
    public static final String PREF_WARNINGS_NOTIFY_SEVERITY_DEFAULT = WeatherWarning.Severity.MINOR;
    public static final boolean PREF_IS_FIRST_APP_LAUNCH_DEFAULT = true;
    public static final boolean PREF_USEGPS_DEFAULT = true;
    public static final boolean PREF_GPSAUTO_DEFAULT = false;
    public static final boolean PREF_GPSMANUAL_DEFAULT = false;
    public static final long PREF_LASTGPSFIX_DEFAULT = 0;
    public static final boolean PREF_DISABLE_TLS_DEFAULT = false;
    public static final long PREF_TEXTFORECAST_LAST_UPDATE_TIME_DEFAULT = 0;
    public static final boolean PREF_TEXTFORECAST_FILTER_DEFAULT = false;
    public static final long PREF_RADAR_LASTDATAPOLL_DEFAULT = 0;
    public static final boolean PREF_RADAR_SHOW_DEFAULT = true;
    public static final boolean PREF_ADMINMAP_SHOW_DEFAULT=false;
    public static final boolean PREF_MAP_DISPLAY_MUNICIPALITIES_DEFAULT = false;
    public static final boolean PREF_MAP_DISPLAY_COUNTIES_DEFAULT = true;
    public static final boolean PREF_MAP_DISPLAY_STATES_DEFAULT = false;
    public static final boolean PREF_MAP_DISPLAY_SEA_AREAS_DEFAULT = false;
    public static final boolean PREF_MAP_DISPLAY_COAST_AREAS_DEFAULT = false;
    public static final boolean PREF_FORCE_NO_MENU_ICONS_DEFAULT = false;
    public static final boolean PREF_DISPLAY_WIND_IN_RADAR_DEFAULT = true;
    public static final boolean PREF_AREA_DATABASE_READY_DEFAULT = false;
    public static final int PREF_AREA_DATABASE_VERSION_DEFAULT = 0;
    public static final String PREF_VIEWMODEL_DEFAULT = ViewModel.SIMPLE;
    public static final String PREF_THEME_DEFAULT = Theme.FOLLOW_DEVICE;
    public static final boolean PREF_ALTERNATIVE_ICONS_DEFAULT = true;
    public static final boolean PREF_USE_METERED_NETWORKS_DEFAULT = true;
    public static final int PREF_NOTIFICATION_IDENTIFIER_DEFAULT = -2147483640;
    public static final boolean PREF_ASKEDFORLOCATIONPERMISSION_DEFAULT = false;
    public static final String PREF_ROTATIONMODE_DEFAULT = DeviceRotation.DEVICE;
    public static final long PREF_NC_CHANNEL_DETAIL_DEFAULT = 0;
    public static final int PREF_LED_COLOR_DEFAULT = 0;
    public static final boolean PREF_WARNINGS_NOTIFY_LED_DEFAULT = true;
    public static final int PREF_HINTCOUNTER1_DEFAULT = 0;
    public static final int PREF_HINTCOUNTER2_DEFAULT = 0;
    public static final long PREF_UVIMAPLASTUPDATETIME_DEFAULT = 0;
    public static final long PREF_LAYERTIME_DEFAULT = 0;
    public static final int PREF_LASTMAPDISPLAYED_DEFAULT = WeatherLayer.Layers.UVI_CLOUDS_0;

    public String location_description = PREF_LOCATION_DESCRIPTION_DEFAULT;
    public String station_name = PREF_STATION_NAME_DEFAULT;
    public double longitude = PREF_LONGITUDE_DEFAULT;
    public double latitude = PREF_LATITUDE_DEFAULT;
    public double altitude = PREF_ALTITUDE_DEFAULT;
    public int stationType = PREF_STATIONTYPE_DEFAULT;
    public boolean display_station_geo = PREF_DISPLAY_STATION_GEO_DEFAULT;
    public String display_type = PREF_DISPLAY_TYPE_DEFAULT;
    public String display_layout = PREF_DISPLAY_LAYOUT_DEFAULT;
    public boolean display_bar = PREF_DISPLAY_BAR_DEFAULT;
    public boolean display_simple_bar = PREF_DISPLAY_SIMPLE_BAR_DEFAULT;
    public boolean display_pressure = PREF_DISPLAY_PRESSURE_DEFAULT;
    public boolean display_visibility = PREF_DISPLAY_VISIBILITY_DEFAULT;
    public boolean display_sunrise = PREF_DISPLAY_SUNRISE_DEFAULT;
    public boolean display_endofday_bar = PREF_DISPLAY_ENDOFDAY_BAR_DEFAULT;
    public boolean display_gradient = PREF_DISPLAY_GRADIENT_DEFAULT;
    public boolean display_wind_arc = PREF_DISPLAY_WIND_ARC_DEFAULT;
    public String display_wind_arc_period = PREF_DISPLAY_WIND_ARC_PERIOD_DEFAULT;
    public String display_wind_type = PREF_DISPLAY_WIND_TYPE_DEFAULT;
    public String display_wind_unit = PREF_DISPLAY_WIND_UNIT_DEFAULT;
    public String display_distance_unit = PREF_DISPLAY_DISTANCE_UNIT_DEFAULT;
    public boolean cropPrecipitationChart = PREF_DISPLAY_CROP_PRECIPITATIONCHART_DEFAULT;
    public boolean displayOverviewChart = PREF_DISPLAY_OVERVIEWCHART_DEFAULT;
    public int displayOverviewChartDays = PREF_DISPLAY_OVERVIEWCHART_DAYS_DEFAULT;
    public boolean displayOverviewChartUseMinMax = PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE_DEFAULT;
    public int displayOverviewChartMin = PREF_DISPLAY_OVERVIEWCHART_MIN_DEFAULT;
    public int displayOverviewChartMax = PREF_DISPLAY_OVERVIEWCHART_MAX_DEFAULT;
    public boolean setalarm = PREF_SETALARM_DEFAULT;
    public String updateinterval = PREF_UPDATEINTERVAL_DEFAULT;
    public long lastWidgetUpdateTime = PREF_LASTWIDGETUPDATETIME_DEFAULT;
    public boolean update_warnings = PREF_UPDATE_WARNINGS_DEFAULT;
    public boolean update_textforecasts = PREF_UPDATE_TEXTFORECASTS_DEFAULT;
    public String widget_opacity = PREF_WIDGET_OPACITY_DEFAULT;
    public boolean widget_showdwdnote = PREF_WIDGET_SHOWDWDNOTE_DEFAULT;
    public boolean widget_displaywarnings = PREF_WIDGET_DISPLAYWARNINGS_DEFAULT;
    public boolean notify_warnings = PREF_NOTIFY_WARNINGS_DEFAULT;
    public int last_version_code = PREF_LAST_VERSION_CODE_DEFAULT;
    public boolean serve_gadgetbridge = PREF_SERVE_GADGETBRIDGE_DEFAULT;
    public long views_last_update_time = PREF_VIEWS_LAST_UPDATE_TIME_DEFAULT;
    public long warnings_last_update_time = PREF_WARNINGS_LAST_UPDATE_TIME_DEFAULT;
    public String notifySeverity = PREF_WARNINGS_NOTIFY_SEVERITY_DEFAULT;
    public String gadgetbridge_packagename = PREF_GADGETBRIDGE_PACKAGENAME_DEFAULT;
    public boolean gadgetbridge_fake_timestamp = PREF_GADGETBRIDGE_FAKE_TIMESTAMP_DEFAULT;
    public boolean logging = PREF_LOGGING_DEFAULT;
    public boolean log_to_logcat = PREF_LOG_TO_LOGCAT_DEFAULT;
    public String favoritesdata = PREF_FAVORITESDATA_DEFAULT;
    public String warnings_cache_time = PREF_WARNINGS_CACHETIME_DEFAULT;
    public boolean warnings_disabled = PREF_WARNINGS_DISABLE_DEFAULT;
    public boolean is_first_app_launch = true;
    public boolean usegps = PREF_USEGPS_DEFAULT;
    public boolean gpsauto = PREF_GPSAUTO_DEFAULT;
    public boolean gpsmanual = PREF_GPSMANUAL_DEFAULT;
    public long lastgpsfix = PREF_LASTGPSFIX_DEFAULT;
    public boolean disable_tls = PREF_DISABLE_TLS_DEFAULT;
    public long textforecast_last_update_time = PREF_TEXTFORECAST_LAST_UPDATE_TIME_DEFAULT;
    public boolean textforecast_filter = PREF_TEXTFORECAST_FILTER_DEFAULT;
    public long radar_lastdatapoll = PREF_RADAR_LASTDATAPOLL_DEFAULT;
    public boolean radar_show = PREF_RADAR_SHOW_DEFAULT;
    public boolean adminmap_show = PREF_ADMINMAP_SHOW_DEFAULT;
    public boolean mapDisplayMunicipalities = PREF_MAP_DISPLAY_MUNICIPALITIES_DEFAULT;
    public boolean mapDisplayCounties = PREF_MAP_DISPLAY_COUNTIES_DEFAULT;
    public boolean mapDisplayStates = PREF_MAP_DISPLAY_STATES_DEFAULT;
    public boolean mapDisplaySeaAreas = PREF_MAP_DISPLAY_SEA_AREAS_DEFAULT;
    public boolean mapDisplayCoastAreas = PREF_MAP_DISPLAY_COAST_AREAS_DEFAULT;
    public boolean forceNoMenuIcons = PREF_FORCE_NO_MENU_ICONS_DEFAULT;
    public boolean display_wind_in_radar = PREF_DISPLAY_WIND_IN_RADAR_DEFAULT;
    public boolean area_database_ready = PREF_AREA_DATABASE_READY_DEFAULT;
    public int area_database_version = PREF_AREA_DATABASE_VERSION_DEFAULT;
    public String viewModel = PREF_VIEWMODEL_DEFAULT;
    public String theme = PREF_THEME_DEFAULT;
    public boolean preferAlternativeIcons = PREF_ALTERNATIVE_ICONS_DEFAULT;
    public boolean useMeteredNetworks = PREF_USE_METERED_NETWORKS_DEFAULT;
    public int notificationIdentifier = PREF_NOTIFICATION_IDENTIFIER_DEFAULT;
    private boolean askedforlocationpermission = PREF_ASKEDFORLOCATIONPERMISSION_DEFAULT;
    public String rotationMode = PREF_ROTATIONMODE_DEFAULT;
    public long ncChannelDetail = PREF_NC_CHANNEL_DETAIL_DEFAULT;
    public int ledColor = PREF_LED_COLOR_DEFAULT;
    public boolean useLED = PREF_WARNINGS_NOTIFY_LED_DEFAULT;
    public int hintCounter1 = PREF_HINTCOUNTER1_DEFAULT;
    public int hintCounter2 = PREF_HINTCOUNTER2_DEFAULT;
    public long uviLastUpdateTime = PREF_UVIMAPLASTUPDATETIME_DEFAULT;

    private Context context;
    public SharedPreferences sharedPreferences;

    public WeatherSettings(Context c) {
        this.context = c;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        readPreferences();
    }

    public void readPreferences() {
        this.location_description = readPreference(PREF_LOCATION_DESCRIPTION, PREF_LOCATION_DESCRIPTION_DEFAULT);
        this.station_name = readPreference(PREF_STATION_NAME, PREF_STATION_NAME_DEFAULT);
        this.longitude = readPreference(PREF_LONGITUDE, PREF_LONGITUDE_DEFAULT);
        this.latitude = readPreference(PREF_LATITUDE, PREF_LATITUDE_DEFAULT);
        this.altitude = readPreference(PREF_ALTITUDE, PREF_ALTITUDE_DEFAULT);
        this.stationType = readPreference(PREF_STATIONTYPE,PREF_STATIONTYPE_DEFAULT);
        this.setalarm = readPreference(PREF_SETALARM, PREF_SETALARM_DEFAULT);
        this.display_station_geo = readPreference(PREF_DISPLAY_STATION_GEO, PREF_DISPLAY_STATION_GEO_DEFAULT);
        this.display_type = readPreference(PREF_DISPLAY_TYPE, PREF_DISPLAY_TYPE_DEFAULT);
        this.display_layout = readPreference(PREF_DISPLAY_LAYOUT,PREF_DISPLAY_LAYOUT_DEFAULT);
        this.display_bar = readPreference(PREF_DISPLAY_BAR, PREF_DISPLAY_BAR_DEFAULT);
        this.display_simple_bar = readPreference(PREF_DISPLAY_SIMPLE_BAR,PREF_DISPLAY_SIMPLE_BAR_DEFAULT);
        this.display_pressure = readPreference(PREF_DISPLAY_PRESSURE, PREF_DISPLAY_PRESSURE_DEFAULT);
        this.display_visibility = readPreference(PREF_DISPLAY_VISIBILITY, PREF_DISPLAY_VISIBILITY_DEFAULT);
        this.display_sunrise = readPreference(PREF_DISPLAY_SUNRISE, PREF_DISPLAY_SUNRISE_DEFAULT);
        this.display_endofday_bar = readPreference(PREF_DISPLAY_ENDOFDAY_BAR, PREF_DISPLAY_ENDOFDAY_BAR_DEFAULT);
        this.display_gradient = readPreference(PREF_DISPLAY_GRADIENT, PREF_DISPLAY_GRADIENT_DEFAULT);
        this.display_wind_arc = readPreference(PREF_DISPLAY_WIND_ARC,PREF_DISPLAY_WIND_ARC_DEFAULT);
        this.display_wind_arc_period = readPreference(PREF_DISPLAY_WIND_ARC_PERIOD,PREF_DISPLAY_WIND_ARC_PERIOD_DEFAULT);
        this.display_wind_type = readPreference(PREF_DISPLAY_WIND_TYPE,PREF_DISPLAY_WIND_TYPE_DEFAULT);
        this.display_wind_unit = readPreference(PREF_DISPLAY_WIND_UNIT,PREF_DISPLAY_WIND_TYPE_DEFAULT);
        this.display_distance_unit = readPreference(PREF_DISPLAY_DISTANCE_UNIT,PREF_DISPLAY_DISTANCE_UNIT_DEFAULT);
        this.cropPrecipitationChart = readPreference(PREF_DISPLAY_CROP_PRECIPITATIONCHART,PREF_DISPLAY_CROP_PRECIPITATIONCHART_DEFAULT);
        this.displayOverviewChart = readPreference(PREF_DISPLAY_OVERVIEWCHART,PREF_DISPLAY_OVERVIEWCHART_DEFAULT);
        this.displayOverviewChartDays = readPreference(PREF_DISPLAY_OVERVIEWCHART_DAYS,PREF_DISPLAY_OVERVIEWCHART_DAYS_DEFAULT);
        this.displayOverviewChartUseMinMax = readPreference(PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE,PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE_DEFAULT);
        this.displayOverviewChartMin = readPreference(PREF_DISPLAY_OVERVIEWCHART_MIN,PREF_DISPLAY_OVERVIEWCHART_MIN_DEFAULT);
        this.displayOverviewChartMax = readPreference(PREF_DISPLAY_OVERVIEWCHART_MAX,PREF_DISPLAY_OVERVIEWCHART_MAX_DEFAULT);
        this.updateinterval = readPreference(PREF_UPDATEINTERVAL, PREF_UPDATEINTERVAL_DEFAULT);
        this.update_warnings = readPreference(PREF_UPDATE_WARNINGS,PREF_UPDATE_WARNINGS_DEFAULT);
        this.update_textforecasts = readPreference(PREF_UPDATE_TEXTFORECASTS,PREF_UPDATE_TEXTFORECASTS_DEFAULT);
        this.widget_opacity = readPreference(PREF_WIDGET_OPACITY, PREF_WIDGET_OPACITY_DEFAULT);
        this.widget_showdwdnote = readPreference(PREF_WIDGET_SHOWDWDNOTE, PREF_WIDGET_SHOWDWDNOTE_DEFAULT);
        this.widget_displaywarnings = readPreference(PREF_WIDGET_DISPLAYWARNINGS,PREF_WIDGET_DISPLAYWARNINGS_DEFAULT);
        this.notify_warnings = readPreference(PREF_NOTIFY_WARNINGS,PREF_NOTIFY_WARNINGS_DEFAULT);
        this.last_version_code = readPreference(PREF_LAST_VERSION_CODE, PREF_LAST_VERSION_CODE_DEFAULT);
        this.serve_gadgetbridge = readPreference(PREF_SERVE_GADGETBRIDGE, PREF_SERVE_GADGETBRIDGE_DEFAULT);
        this.views_last_update_time = readPreference(PREF_VIEWS_LAST_UPDATE_TIME, PREF_VIEWS_LAST_UPDATE_TIME_DEFAULT);
        this.gadgetbridge_packagename = readPreference(PREF_GADGETBRIDGE_PACKAGENAME,PREF_GADGETBRIDGE_PACKAGENAME_DEFAULT);
        this.gadgetbridge_fake_timestamp = readPreference(PREF_GADGETBRIDGE_FAKE_TIMESTAMP, PREF_GADGETBRIDGE_FAKE_TIMESTAMP_DEFAULT);
        this.logging = readPreference(PREF_LOGGING, PREF_LOGGING_DEFAULT);
        this.log_to_logcat = readPreference(PREF_LOG_TO_LOGCAT, PREF_LOG_TO_LOGCAT_DEFAULT);
        this.favoritesdata = readPreference(PREF_FAVORITESDATA, PREF_FAVORITESDATA_DEFAULT);
        this.warnings_cache_time = readPreference(PREF_WARNINGS_CACHETIME, PREF_WARNINGS_CACHETIME_DEFAULT);
        this.warnings_disabled = readPreference(PREF_WARNINGS_DISABLE, PREF_WARNINGS_DISABLE_DEFAULT);
        this.warnings_last_update_time = readPreference(PREF_WARNINGS_LAST_UPDATE_TIME, PREF_WARNINGS_LAST_UPDATE_TIME_DEFAULT);
        this.notifySeverity = readPreference(PREF_WARNINGS_NOTIFY_SEVERITY,PREF_WARNINGS_NOTIFY_SEVERITY_DEFAULT);
        this.is_first_app_launch = readPreference(PREF_IS_FIRST_APP_LAUNCH, PREF_IS_FIRST_APP_LAUNCH_DEFAULT);
        this.usegps = readPreference(PREF_USEGPS,PREF_USEGPS_DEFAULT);
        this.gpsauto = readPreference(PREF_GPSAUTO,PREF_GPSAUTO_DEFAULT);
        this.gpsmanual = readPreference(PREF_GPSMANUAL,PREF_GPSMANUAL_DEFAULT);
        this.disable_tls = readPreference(PREF_DISABLE_TLS,PREF_DISABLE_TLS_DEFAULT);
        this.textforecast_last_update_time = readPreference(PREF_TEXTFORECAST_LAST_UPDATE_TIME,PREF_TEXTFORECAST_LAST_UPDATE_TIME_DEFAULT);
        this.textforecast_filter = readPreference(PREF_TEXTFORECAST_FILTER,PREF_TEXTFORECAST_FILTER_DEFAULT);
        this.radar_lastdatapoll = readPreference(PREF_RADAR_LASTDATAPOLL,PREF_RADAR_LASTDATAPOLL_DEFAULT);
        this.radar_show = readPreference(PREF_RADAR_SHOW,PREF_RADAR_SHOW_DEFAULT);
        this.adminmap_show = readPreference(PREF_ADMINMAP_SHOW,PREF_ADMINMAP_SHOW_DEFAULT);
        this.mapDisplayMunicipalities = PREF_MAP_DISPLAY_MUNICIPALITIES_DEFAULT;
        this.mapDisplayCounties = PREF_MAP_DISPLAY_COUNTIES_DEFAULT;
        this.mapDisplayStates = PREF_MAP_DISPLAY_STATES_DEFAULT;
        this.mapDisplaySeaAreas = PREF_MAP_DISPLAY_SEA_AREAS_DEFAULT;
        this.mapDisplayCoastAreas = PREF_MAP_DISPLAY_COAST_AREAS_DEFAULT;
        this.forceNoMenuIcons = readPreference(PREF_FORCE_NO_MENU_ICONS,PREF_FORCE_NO_MENU_ICONS_DEFAULT);
        this.display_wind_in_radar = readPreference(PREF_DISPLAY_WIND_IN_RADAR,PREF_DISPLAY_WIND_IN_RADAR_DEFAULT);
        this.area_database_ready = readPreference(PREF_AREA_DATABASE_READY,PREF_AREA_DATABASE_READY_DEFAULT);
        this.area_database_version = readPreference(PREF_AREA_DATABASE_VERSION,PREF_AREA_DATABASE_VERSION_DEFAULT);
        this.viewModel = readPreference(PREF_VIEWMODEL,PREF_VIEWMODEL_DEFAULT);
        this.theme = readPreference(PREF_THEME,PREF_THEME_DEFAULT);
        this.preferAlternativeIcons = readPreference(PREF_ALTERNATIVE_ICONS,PREF_ALTERNATIVE_ICONS_DEFAULT);
        this.useMeteredNetworks = readPreference(PREF_USE_METERED_NETWORKS,PREF_USE_METERED_NETWORKS_DEFAULT);
        this.notificationIdentifier = readPreference(PREF_NOTIFICATION_IDENTIFIER,PREF_NOTIFICATION_IDENTIFIER_DEFAULT);
        this.rotationMode = readPreference(PREF_ROTATIONMODE,PREF_ROTATIONMODE_DEFAULT);
        this.ncChannelDetail = readPreference(PREF_NC_CHANNEL_DETAIL,PREF_NC_CHANNEL_DETAIL_DEFAULT);
        this.useLED = readPreference(PREF_WARNINGS_NOTIFY_LED,PREF_WARNINGS_NOTIFY_LED_DEFAULT);
        this.hintCounter1 = readPreference(PREF_HINTCOUNTER1,PREF_HINTCOUNTER1_DEFAULT);
        this.hintCounter2 = readPreference(PREF_HINTCOUNTER2,PREF_HINTCOUNTER2_DEFAULT);
        this.uviLastUpdateTime = readPreference(PREF_MAPLASTUPDATETIME,PREF_UVIMAPLASTUPDATETIME_DEFAULT);
    }

    public void savePreferences() {
        applyPreference(PREF_LOCATION_DESCRIPTION, this.location_description);
        applyPreference(PREF_STATION_NAME, this.station_name);
        applyPreference(PREF_LONGITUDE, this.longitude);
        applyPreference(PREF_LATITUDE, this.latitude);
        applyPreference(PREF_ALTITUDE, this.altitude);
        applyPreference(PREF_STATIONTYPE,this.stationType);
        applyPreference(PREF_DISPLAY_STATION_GEO, this.display_station_geo);
        applyPreference(PREF_DISPLAY_TYPE, this.display_type);
        applyPreference(PREF_DISPLAY_LAYOUT,this.display_layout);
        applyPreference(PREF_DISPLAY_BAR, this.display_bar);
        applyPreference(PREF_DISPLAY_SIMPLE_BAR,this.display_simple_bar);
        applyPreference(PREF_DISPLAY_PRESSURE, this.display_pressure);
        applyPreference(PREF_DISPLAY_VISIBILITY, this.display_visibility);
        applyPreference(PREF_DISPLAY_SUNRISE, this.display_sunrise);
        applyPreference(PREF_DISPLAY_ENDOFDAY_BAR, this.display_endofday_bar);
        applyPreference(PREF_DISPLAY_GRADIENT, this.display_gradient);
        applyPreference(PREF_DISPLAY_WIND_ARC,this.display_wind_arc);
        applyPreference(PREF_DISPLAY_WIND_ARC_PERIOD,this.display_wind_arc_period);
        applyPreference(PREF_DISPLAY_WIND_TYPE,this.display_wind_type);
        applyPreference(PREF_DISPLAY_WIND_UNIT,this.display_wind_unit);
        applyPreference(PREF_DISPLAY_DISTANCE_UNIT,this.display_distance_unit);
        applyPreference(PREF_DISPLAY_CROP_PRECIPITATIONCHART,this.cropPrecipitationChart);
        applyPreference(PREF_DISPLAY_OVERVIEWCHART,this.displayOverviewChart);
        applyPreference(PREF_DISPLAY_OVERVIEWCHART_DAYS,this.displayOverviewChartDays);
        applyPreference(PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE,this.displayOverviewChartUseMinMax);
        applyPreference(PREF_DISPLAY_OVERVIEWCHART_MIN,this.displayOverviewChartMin);
        applyPreference(PREF_DISPLAY_OVERVIEWCHART_MAX,this.displayOverviewChartMax);
        applyPreference(PREF_SETALARM, this.setalarm);
        applyPreference(PREF_UPDATEINTERVAL, this.updateinterval);
        applyPreference(PREF_UPDATE_WARNINGS, this.update_warnings);
        applyPreference(PREF_UPDATE_TEXTFORECASTS, this.update_textforecasts);
        applyPreference(PREF_WIDGET_OPACITY, this.widget_opacity);
        applyPreference(PREF_WIDGET_SHOWDWDNOTE, this.widget_showdwdnote);
        applyPreference(PREF_WIDGET_DISPLAYWARNINGS,this.widget_displaywarnings);
        applyPreference(PREF_NOTIFY_WARNINGS,this.notify_warnings);
        applyPreference(PREF_LAST_VERSION_CODE, this.last_version_code);
        applyPreference(PREF_SERVE_GADGETBRIDGE, this.serve_gadgetbridge);
        applyPreference(PREF_GADGETBRIDGE_PACKAGENAME,this.gadgetbridge_packagename);
        applyPreference(PREF_GADGETBRIDGE_FAKE_TIMESTAMP, this.gadgetbridge_fake_timestamp);
        applyPreference(PREF_VIEWS_LAST_UPDATE_TIME, this.views_last_update_time);
        applyPreference(PREF_LOGGING, this.logging);
        applyPreference(PREF_LOG_TO_LOGCAT, this.log_to_logcat);
        applyPreference(PREF_WARNINGS_CACHETIME, this.warnings_cache_time);
        applyPreference(PREF_WARNINGS_DISABLE, this.warnings_disabled);
        applyPreference(PREF_WARNINGS_LAST_UPDATE_TIME, this.warnings_last_update_time);
        applyPreference(PREF_WARNINGS_NOTIFY_SEVERITY,this.notifySeverity);
        applyPreference(PREF_IS_FIRST_APP_LAUNCH, this.is_first_app_launch);
        applyPreference(PREF_USEGPS,this.usegps);
        applyPreference(PREF_GPSAUTO,this.gpsauto);
        applyPreference(PREF_GPSMANUAL,this.gpsmanual);
        applyPreference(PREF_DISABLE_TLS,this.disable_tls);
        applyPreference(PREF_TEXTFORECAST_LAST_UPDATE_TIME,this.textforecast_last_update_time);
        applyPreference(PREF_TEXTFORECAST_FILTER,this.textforecast_filter);
        applyPreference(PREF_RADAR_LASTDATAPOLL,this.radar_lastdatapoll);
        applyPreference(PREF_RADAR_SHOW,this.radar_show);
        applyPreference(PREF_ADMINMAP_SHOW,this.adminmap_show);
        applyPreference(PREF_MAP_DISPLAY_MUNICIPALITIES,this.mapDisplayMunicipalities);
        applyPreference(PREF_MAP_DISPLAY_COUNTIES,this.mapDisplayCounties);
        applyPreference(PREF_MAP_DISPLAY_STATES,this.mapDisplayStates);
        applyPreference(PREF_MAP_DISPLAY_SEA_AREAS,this.mapDisplaySeaAreas);
        applyPreference(PREF_MAP_DISPLAY_COAST_AREAS,this.mapDisplayCoastAreas);
        applyPreference(PREF_FORCE_NO_MENU_ICONS,this.forceNoMenuIcons);
        applyPreference(PREF_DISPLAY_WIND_IN_RADAR,this.display_wind_in_radar);
        applyPreference(PREF_AREA_DATABASE_READY,this.area_database_ready);
        applyPreference(PREF_AREA_DATABASE_VERSION,this.area_database_version);
        applyPreference(PREF_VIEWMODEL,this.viewModel);
        applyPreference(PREF_THEME,this.theme);
        applyPreference(PREF_ALTERNATIVE_ICONS,this.preferAlternativeIcons);
        applyPreference(PREF_USE_METERED_NETWORKS,this.useMeteredNetworks);
        applyPreference(PREF_NOTIFICATION_IDENTIFIER,this.notificationIdentifier);
        applyPreference(PREF_ROTATIONMODE,rotationMode);
        applyPreference(PREF_NC_CHANNEL_DETAIL,ncChannelDetail);
        applyPreference(PREF_WARNINGS_NOTIFY_LED,useLED);
        applyPreference(PREF_HINTCOUNTER1,hintCounter1);
        applyPreference(PREF_HINTCOUNTER2,hintCounter2);
        applyPreference(PREF_MAPLASTUPDATETIME,uviLastUpdateTime);
    }

    public void commitPreferences() {
        commitPreference(PREF_LOCATION_DESCRIPTION, this.location_description);
        commitPreference(PREF_STATION_NAME, this.station_name);
        commitPreference(PREF_LONGITUDE, this.longitude);
        commitPreference(PREF_LATITUDE, this.latitude);
        commitPreference(PREF_ALTITUDE, this.altitude);
        commitPreference(PREF_STATIONTYPE,this.stationType);
        commitPreference(PREF_DISPLAY_STATION_GEO, this.display_station_geo);
        commitPreference(PREF_DISPLAY_TYPE, this.display_type);
        commitPreference(PREF_DISPLAY_LAYOUT,this.display_layout);
        commitPreference(PREF_DISPLAY_BAR, this.display_bar);
        commitPreference(PREF_DISPLAY_SIMPLE_BAR,this.display_simple_bar);
        commitPreference(PREF_DISPLAY_PRESSURE, this.display_pressure);
        commitPreference(PREF_DISPLAY_VISIBILITY, this.display_visibility);
        commitPreference(PREF_DISPLAY_SUNRISE, this.display_sunrise);
        commitPreference(PREF_DISPLAY_ENDOFDAY_BAR, this.display_endofday_bar);
        commitPreference(PREF_DISPLAY_GRADIENT, this.display_gradient);
        commitPreference(PREF_DISPLAY_WIND_ARC,this.display_wind_arc);
        commitPreference(PREF_DISPLAY_WIND_ARC_PERIOD,this.display_wind_arc_period);
        commitPreference(PREF_DISPLAY_WIND_TYPE,this.display_wind_type);
        commitPreference(PREF_DISPLAY_WIND_UNIT,this.display_wind_unit);
        commitPreference(PREF_DISPLAY_DISTANCE_UNIT,this.display_distance_unit);
        commitPreference(PREF_DISPLAY_CROP_PRECIPITATIONCHART,this.cropPrecipitationChart);
        commitPreference(PREF_DISPLAY_OVERVIEWCHART,this.displayOverviewChart);
        commitPreference(PREF_DISPLAY_OVERVIEWCHART_DAYS,this.displayOverviewChartDays);
        commitPreference(PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE,this.displayOverviewChartUseMinMax);
        commitPreference(PREF_DISPLAY_OVERVIEWCHART_MIN,this.displayOverviewChartMin);
        commitPreference(PREF_DISPLAY_OVERVIEWCHART_MAX,this.displayOverviewChartMax);
        commitPreference(PREF_SETALARM, this.setalarm);
        commitPreference(PREF_UPDATEINTERVAL, this.updateinterval);
        commitPreference(PREF_UPDATE_WARNINGS, this.update_warnings);
        commitPreference(PREF_UPDATE_TEXTFORECASTS, this.update_textforecasts);
        commitPreference(PREF_WIDGET_OPACITY, this.widget_opacity);
        commitPreference(PREF_WIDGET_SHOWDWDNOTE, this.widget_showdwdnote);
        commitPreference(PREF_WIDGET_DISPLAYWARNINGS,this.widget_displaywarnings);
        commitPreference(PREF_NOTIFY_WARNINGS,this.notify_warnings);
        commitPreference(PREF_LAST_VERSION_CODE, this.last_version_code);
        commitPreference(PREF_SERVE_GADGETBRIDGE, this.serve_gadgetbridge);
        commitPreference(PREF_GADGETBRIDGE_PACKAGENAME,this.gadgetbridge_packagename);
        commitPreference(PREF_GADGETBRIDGE_FAKE_TIMESTAMP, this.gadgetbridge_fake_timestamp);
        commitPreference(PREF_VIEWS_LAST_UPDATE_TIME, this.views_last_update_time);
        commitPreference(PREF_LOGGING, this.logging);
        commitPreference(PREF_LOG_TO_LOGCAT, this.log_to_logcat);
        commitPreference(PREF_WARNINGS_CACHETIME, this.warnings_cache_time);
        commitPreference(PREF_WARNINGS_DISABLE, this.warnings_disabled);
        commitPreference(PREF_WARNINGS_LAST_UPDATE_TIME, this.warnings_last_update_time);
        commitPreference(PREF_WARNINGS_NOTIFY_SEVERITY,this.notifySeverity);
        commitPreference(PREF_IS_FIRST_APP_LAUNCH, this.is_first_app_launch);
        commitPreference(PREF_USEGPS,this.usegps);
        commitPreference(PREF_GPSAUTO,this.gpsauto);
        commitPreference(PREF_GPSMANUAL,this.gpsmanual);
        commitPreference(PREF_DISABLE_TLS,this.disable_tls);
        commitPreference(PREF_TEXTFORECAST_LAST_UPDATE_TIME,this.textforecast_last_update_time);
        commitPreference(PREF_TEXTFORECAST_FILTER,this.textforecast_filter);
        commitPreference(PREF_RADAR_LASTDATAPOLL,this.radar_lastdatapoll);
        commitPreference(PREF_RADAR_SHOW,this.radar_show);
        commitPreference(PREF_ADMINMAP_SHOW,this.adminmap_show);
        commitPreference(PREF_MAP_DISPLAY_MUNICIPALITIES,this.mapDisplayMunicipalities);
        commitPreference(PREF_MAP_DISPLAY_COUNTIES,this.mapDisplayCounties);
        commitPreference(PREF_MAP_DISPLAY_STATES,this.mapDisplayStates);
        commitPreference(PREF_MAP_DISPLAY_SEA_AREAS,this.mapDisplaySeaAreas);
        commitPreference(PREF_MAP_DISPLAY_COAST_AREAS,this.mapDisplayCoastAreas);
        commitPreference(PREF_FORCE_NO_MENU_ICONS,this.forceNoMenuIcons);
        commitPreference(PREF_DISPLAY_WIND_IN_RADAR,this.display_wind_in_radar);
        commitPreference(PREF_AREA_DATABASE_READY,this.area_database_ready);
        commitPreference(PREF_AREA_DATABASE_VERSION,this.area_database_version);
        commitPreference(PREF_VIEWMODEL,this.viewModel);
        commitPreference(PREF_THEME,this.theme);
        commitPreference(PREF_ALTERNATIVE_ICONS,this.preferAlternativeIcons);
        commitPreference(PREF_USE_METERED_NETWORKS,this.useMeteredNetworks);
        commitPreference(PREF_NOTIFICATION_IDENTIFIER,this.notificationIdentifier);
        commitPreference(PREF_ROTATIONMODE,rotationMode);
        commitPreference(PREF_NC_CHANNEL_DETAIL,ncChannelDetail);
        commitPreference(PREF_WARNINGS_NOTIFY_LED,useLED);
        commitPreference(PREF_HINTCOUNTER1,hintCounter1);
        commitPreference(PREF_HINTCOUNTER2,hintCounter2);
        commitPreference(PREF_MAPLASTUPDATETIME,uviLastUpdateTime);
    }

    public static void resetPreferencesToDefault(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.clear();
        pref_editor.commit();
    }

    public String readPreference(String p, String d) {
        return sharedPreferences.getString(p, d);
    }

    public Boolean readPreference(String p, Boolean d) {
        return sharedPreferences.getBoolean(p, d);
    }

    public int readPreference(String p, int d) {
        return sharedPreferences.getInt(p, d);
    }

    public float readPreference(String p, float d) {
        return sharedPreferences.getFloat(p, d);
    }

    public long readPreference(String p, long d) {
        return sharedPreferences.getLong(p, d);
    }

    public double readPreference(String p, double d) {
        return (double) sharedPreferences.getFloat(p, (float) d);
    }

    public void applyPreference(String pref, String value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(pref, value);
        pref_editor.apply();
    }

    public void applyPreference(String pref, Boolean value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(pref, value);
        pref_editor.apply();
    }

    public void applyPreference(String pref, int value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putInt(pref, value);
        pref_editor.apply();
    }

    public void applyPreference(String pref, float value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putFloat(pref, value);
        pref_editor.apply();
    }

    public void applyPreference(String pref, long value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putLong(pref, value);
        pref_editor.apply();
    }

    public void applyPreference(String pref, double value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        applyPreference(pref, (float) value);
        pref_editor.apply();
    }

    public void commitPreference(String pref, String value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(pref, value);
        pref_editor.commit();
    }

    public void commitPreference(String pref, Boolean value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(pref, value);
        pref_editor.commit();
    }

    public void commitPreference(String pref, int value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putInt(pref, value);
        pref_editor.commit();
    }

    public void commitPreference(String pref, float value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putFloat(pref, value);
        pref_editor.commit();
    }

    public void commitPreference(String pref, long value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putLong(pref, value);
        pref_editor.commit();
    }

    public void commitPreference(String pref, double value) {
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        applyPreference(pref, (float) value);
        pref_editor.commit();
    }

    public static Weather.WeatherLocation getSetStationLocation(Context context) {
        Weather.WeatherLocation weatherLocation = new Weather.WeatherLocation();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        weatherLocation.description = sharedPreferences.getString(PREF_LOCATION_DESCRIPTION,PREF_LOCATION_DESCRIPTION_DEFAULT);
        weatherLocation.name = sharedPreferences.getString(PREF_STATION_NAME,PREF_STATION_NAME_DEFAULT);
        weatherLocation.latitude = sharedPreferences.getFloat(PREF_LATITUDE,(float) PREF_LATITUDE_DEFAULT);
        weatherLocation.longitude = sharedPreferences.getFloat(PREF_LONGITUDE,(float) PREF_LONGITUDE_DEFAULT);
        weatherLocation.altitude = sharedPreferences.getFloat(PREF_ALTITUDE,(float) PREF_ALTITUDE_DEFAULT);
        weatherLocation.type = sharedPreferences.getInt(PREF_STATIONTYPE, PREF_STATIONTYPE_DEFAULT);
        return weatherLocation;
    }

    public static void setStation(Context context, Weather.WeatherLocation weatherLocation) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(PREF_LOCATION_DESCRIPTION, weatherLocation.description);
        pref_editor.putString(PREF_STATION_NAME,weatherLocation.name);
        pref_editor.putFloat(PREF_LATITUDE,(float) weatherLocation.latitude);
        pref_editor.putFloat(PREF_LONGITUDE,(float) weatherLocation.longitude);
        pref_editor.putFloat(PREF_ALTITUDE,(float) weatherLocation.altitude);
        pref_editor.putInt(PREF_STATIONTYPE, weatherLocation.type);
        pref_editor.apply();
    }

    public static void resetStationToDefault(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(PREF_STATION_NAME, PREF_STATION_NAME_DEFAULT);
        pref_editor.putFloat(PREF_LATITUDE, (float) PREF_LATITUDE_DEFAULT);
        pref_editor.putFloat(PREF_LONGITUDE, (float) PREF_LONGITUDE_DEFAULT);
        pref_editor.putFloat(PREF_ALTITUDE, (float) PREF_ALTITUDE_DEFAULT);
        pref_editor.putInt(PREF_STATIONTYPE,PREF_STATIONTYPE_DEFAULT);
        pref_editor.putString(PREF_FAVORITESDATA,PREF_FAVORITESDATA_DEFAULT);
        pref_editor.apply();
    }

    public static void updateFavorites(Context context, ArrayList<Weather.WeatherLocation> favorites) {
        String result = "";
        for (int i = 0; i < favorites.size(); i++) {
            result = result + favorites.get(i).name + FAVORITES_SEPERATOR;
        }
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(PREF_FAVORITESDATA, result);
        pref_editor.commit();
    }

    public ArrayList<String> getFavorites() {
        ArrayList<String> result = new ArrayList<String>();
        String[] split_descriptions = this.favoritesdata.split(FAVORITES_SEPERATOR);
        for (int i = 0; i < split_descriptions.length; i++) {
            result.add(split_descriptions[i]);
        }
        // if favorites are corrupted, simply reset to display current station only and return default
        if (split_descriptions.length==0){
            result.add(this.location_description);
            this.favoritesdata = this.location_description;
            applyPreference(PREF_FAVORITESDATA,this.favoritesdata);
        }
        return result;
    }

    public static ArrayList<Weather.WeatherLocation> getFavoritesWeatherLocations(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String favoritesData = sharedPreferences.getString(PREF_FAVORITESDATA,PREF_FAVORITESDATA_DEFAULT);
        String[] namesArray = favoritesData.split(FAVORITES_SEPERATOR);
        // convert array to arrayList
        ArrayList<String> names = new ArrayList<String>();
        for (int i=0; i<namesArray.length; i++){
            names.add(namesArray[i]);
        }
        ArrayList<Weather.WeatherLocation> favorites = new ArrayList<Weather.WeatherLocation>();
        ArrayList<Weather.WeatherLocation> weatherLocations = StationsManager.readStations(context);
        for (int i=0; i<names.size(); i++){
            for (int j=0; j<weatherLocations.size(); j++){
                Weather.WeatherLocation weatherLocation = weatherLocations.get(j);
                if (weatherLocation.name.equals(names.get(i))){
                    favorites.add(weatherLocation);
                }
            }
        }
        return favorites;
    }

    public int getDisplayType() {
        try {
            int i = Integer.parseInt(this.display_type);
            return i;
        } catch (NumberFormatException e) {
            // return to default if entry is corrupted (not a number)
            this.display_type = PREF_DISPLAY_TYPE_DEFAULT;
            applyPreference(PREF_DISPLAY_TYPE, display_type);
            // return default
            return DISPLAYTYPE_6HOURS;
        }
    }

    public static void setDisplayType(Context context, String s){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(PREF_DISPLAY_TYPE, s);
        pref_editor.apply();
    }

    public static int getDisplayType(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String display_type = sharedPreferences.getString(PREF_DISPLAY_TYPE,PREF_DISPLAY_TYPE_DEFAULT);
        try {
            int i = Integer.parseInt(display_type);
            return i;
        } catch (NumberFormatException e) {
            // return to default if entry is corrupted (not a number)
            setDisplayType(context,PREF_DISPLAY_TYPE_DEFAULT);
            return DISPLAYTYPE_6HOURS;
        }
    }

    public static boolean serveGadgetBridge(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_SERVE_GADGETBRIDGE,PREF_SERVE_GADGETBRIDGE_DEFAULT);
    }

    public static boolean fakeTimestampForGadgetBridge(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_GADGETBRIDGE_FAKE_TIMESTAMP,PREF_GADGETBRIDGE_FAKE_TIMESTAMP_DEFAULT);
    }

    public static boolean getUpdateForecastRegularly(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_SETALARM,PREF_SETALARM_DEFAULT);
    }

    public static void setUpdateForecastRegularly(Context context, boolean b){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_SETALARM, b);
        pref_editor.apply();
    }

    public static int getForecastUpdateInterval(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i = Integer.parseInt(sharedPreferences.getString(PREF_UPDATEINTERVAL,PREF_UPDATEINTERVAL_DEFAULT));
        return i;
    }

    public static boolean forecastUpdateIntervalIs6h(Context context){
        return (getForecastUpdateInterval(context)==6);
    }

    public static long getForecastUpdateIntervalInMillis(Context context) {
        return (long) getForecastUpdateInterval(context) * 60 * 60 * 1000;
    }

    public static void setLastWidgetUpdateTime(Context context, long time){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putLong(PREF_LASTWIDGETUPDATETIME,time);
        pref_editor.apply();
    }

    public static boolean isWidgetForecastCheckDue(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            int interval = Integer.parseInt(sharedPreferences.getString(PREF_UPDATEINTERVAL, PREF_UPDATEINTERVAL_DEFAULT));
            long lastWidgetUpdateTime = sharedPreferences.getLong(PREF_LASTWIDGETUPDATETIME,PREF_LASTWIDGETUPDATETIME_DEFAULT);
            long time = Calendar.getInstance().getTimeInMillis();
            if (lastWidgetUpdateTime+interval > time) {
                setLastWidgetUpdateTime(context,time);
                return true;
            }
        } catch (NumberFormatException e){
            return true;
        }
        return false;
    }

    public static int getWarningsUpdateIntervalInMillis(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            int i = Integer.parseInt(sharedPreferences.getString(PREF_WARNINGS_CACHETIME, PREF_WARNINGS_CACHETIME_DEFAULT));
            return i * 60 * 1000;
        } catch (Exception e){
            return 30 * 60 * 1000;
        }
    }

    public long getWarningsLastUpdateTime() {
        return warnings_last_update_time;
    }

    public static boolean areWarningsOutdated(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        long getWarningsLastUpdateTime = sharedPreferences.getLong(PREF_WARNINGS_LAST_UPDATE_TIME,PREF_WARNINGS_LAST_UPDATE_TIME_DEFAULT);
        long getWarningsUpdateIntervalInMillis = getWarningsUpdateIntervalInMillis(context);
        boolean result = getWarningsLastUpdateTime + getWarningsUpdateIntervalInMillis <= Calendar.getInstance().getTimeInMillis();
        return  result;
    }

    public static boolean areWarningsDisabled(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_WARNINGS_DISABLE,PREF_WARNINGS_DISABLE_DEFAULT);
    }

    public void setWarningsLastUpdateTime(long time) {
        applyPreference(PREF_WARNINGS_LAST_UPDATE_TIME, time);
    }

    public void setWarningsLastUpdateTime() {
        setWarningsLastUpdateTime(Calendar.getInstance().getTimeInMillis());
    }

    public static boolean notifyWarnings(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_NOTIFY_WARNINGS,PREF_NOTIFY_WARNINGS_DEFAULT);
    }

    public static void setNotifyWarnings(Context context, boolean b){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_NOTIFY_WARNINGS, b);
        pref_editor.apply();
    }

    public static boolean displayWarningsInWidget(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedPreferences.getBoolean(PREF_WARNINGS_DISABLE,PREF_WARNINGS_DISABLE_DEFAULT)){
            return false;
        }
        return sharedPreferences.getBoolean(PREF_WIDGET_DISPLAYWARNINGS,PREF_WIDGET_DISPLAYWARNINGS_DEFAULT);
    }

    public static void setDisplayWarningsInWidget(Context context, boolean b){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_WIDGET_DISPLAYWARNINGS, b);
        pref_editor.apply();
    }

    public static int getWarningsNotifySeverity(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String result = sharedPreferences.getString(PREF_WARNINGS_NOTIFY_SEVERITY,PREF_WARNINGS_NOTIFY_SEVERITY_DEFAULT);
        return WeatherWarning.Severity.toInt(result);
    }

    public static long getTextForecastLastUpdateTimeInMillis(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getLong(PREF_TEXTFORECAST_LAST_UPDATE_TIME,PREF_TEXTFORECAST_LAST_UPDATE_TIME_DEFAULT);
    }

    public static final long TEXTFORECASTS_UPDATE_INTERVAL = 12*60*60*1000;

    public static boolean areTextForecastsOutdated(Context context){
        return getTextForecastLastUpdateTimeInMillis(context) + TEXTFORECASTS_UPDATE_INTERVAL <= Calendar.getInstance().getTimeInMillis();
    }

    public static boolean isFirstAppLaunch(Context c) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        return sharedPreferences.getBoolean(PREF_IS_FIRST_APP_LAUNCH, PREF_IS_FIRST_APP_LAUNCH_DEFAULT);
    }

    public static void setAppLaunchedFlag(Context c) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_IS_FIRST_APP_LAUNCH, false);
        pref_editor.apply();
    }

    public static void resetAppLaunchedFlag(Context c) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_IS_FIRST_APP_LAUNCH, true);
        pref_editor.apply();
    }

    public static void setCurrentAppVersionFlag(Context c){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putInt(PREF_LAST_VERSION_CODE, BuildConfig.VERSION_CODE);
        pref_editor.apply();
    }

    public static boolean getUseGPSFlag(Context c){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        return sharedPreferences.getBoolean(PREF_USEGPS, PREF_USEGPS_DEFAULT);
    }

    public static void setUSEGPSFlag(Context c, boolean flag){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_USEGPS, flag);
        pref_editor.apply();
    }

    public static boolean GPSManual(Context c){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        return sharedPreferences.getBoolean(PREF_GPSMANUAL, PREF_GPSMANUAL_DEFAULT);
    }

    public static boolean GPSAuto(Context c){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        return sharedPreferences.getBoolean(PREF_GPSAUTO, PREF_GPSAUTO_DEFAULT);
    }

    public static void saveGPSfixtime(Context context, long time){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putLong(PREF_LASTGPSFIX,time);
        pref_editor.apply();
    }

    public static long getlastGPSfixtime(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getLong(PREF_LASTGPSFIX, PREF_LASTGPSFIX_DEFAULT);
    }

    public static boolean isGPSFixOutdated(Context context, long time){
        long lastgpsfix = getlastGPSfixtime(context);
        return (time > (lastgpsfix+WeatherLocationManager.GPSFIXINTERVAL));
    }

    public static boolean isLastGPSFixOutdated(Context context){
        long time = Calendar.getInstance().getTimeInMillis();
        return isGPSFixOutdated(context,time);
    }


    public static boolean isTLSdisabled(Context c){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        return sharedPreferences.getBoolean(PREF_DISABLE_TLS, PREF_DISABLE_TLS_DEFAULT);
    }

    public static void setDisableTLS(Context c, boolean flag){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_DISABLE_TLS, flag);
        pref_editor.apply();
    }

    public static boolean appReleaseIsUserdebug() {
        return BuildConfig.VERSION_NAME.contains("debug");
    }

    public int getDisplayLayout(){
        if (this.display_layout.equals("0")){
            return Weather.DisplayLayout.DEFAULT;
        }
        return Weather.DisplayLayout.DEFAULT;
    }

    public static int getWindDisplayType(String s){
        try {
            int i = Integer.parseInt(s);
            return i;
        } catch (NumberFormatException e) {
            return Weather.WindDisplayType.ARROW;
        }
    }

    public int getWindDisplayType(){
        try {
            int i = Integer.parseInt(this.display_wind_type);
            return i;
        } catch (NumberFormatException e) {
            // return to default if entry is corrupted (not a number)
            this.display_wind_type = PREF_DISPLAY_WIND_TYPE_DEFAULT;
            applyPreference(PREF_DISPLAY_WIND_TYPE, display_wind_type);
            // return default
            return Weather.WindDisplayType.ARROW;
        }
    }

    public static int getWindDisplayUnit(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            int i = Integer.parseInt(sharedPreferences.getString(PREF_DISPLAY_WIND_UNIT,PREF_DISPLAY_WIND_UNIT_DEFAULT));
            return i;
        } catch (NumberFormatException e) {
            // return to default if entry is corrupted (not a number)
            SharedPreferences.Editor pref_editor = sharedPreferences.edit();
            pref_editor.putString(PREF_DISPLAY_WIND_UNIT,PREF_DISPLAY_WIND_UNIT_DEFAULT);
            pref_editor.apply();
            // return default
            return Weather.WindDisplayUnit.METERS_PER_SECOND;
        }
    }

    public static int getDistanceDisplayUnit(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            int i = Integer.parseInt(sharedPreferences.getString(PREF_DISPLAY_DISTANCE_UNIT,PREF_DISPLAY_DISTANCE_UNIT_DEFAULT));
            return i;
        } catch (NumberFormatException e) {
            // return to default if entry is corrupted (not a number)
            SharedPreferences.Editor pref_editor = sharedPreferences.edit();
            pref_editor.putString(PREF_DISPLAY_DISTANCE_UNIT,PREF_DISPLAY_DISTANCE_UNIT_DEFAULT);
            pref_editor.apply();
            // return default
            return Weather.DistanceDisplayUnit.METRIC;
        }
    }

    public boolean displayWindArc(){
        return display_wind_arc;
    }

    public static int getWindArcPeriod(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            int i = Integer.parseInt(sharedPreferences.getString(PREF_DISPLAY_WIND_ARC_PERIOD,PREF_DISPLAY_WIND_ARC_PERIOD_DEFAULT));
            return i;
        } catch (NumberFormatException e) {
            // return to default if entry is corrupted (not a number)
            SharedPreferences.Editor pref_editor = sharedPreferences.edit();
            pref_editor.putString(PREF_DISPLAY_WIND_ARC_PERIOD,PREF_DISPLAY_WIND_ARC_PERIOD_DEFAULT);
            pref_editor.apply();
            // return default, is 6
            return 6;
        }
    }

    public static boolean getDisplayWindArc(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_DISPLAY_WIND_ARC, PREF_DISPLAY_WIND_ARC_DEFAULT);
    }

    public static void setDisplayWindArc(Context context, boolean b){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_DISPLAY_WIND_ARC, b);
        pref_editor.apply();
    }

    public static void setLastTextForecastsUpdateTime(Context context, long time){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putLong(PREF_TEXTFORECAST_LAST_UPDATE_TIME, time);
        pref_editor.apply();
    }

    public static long getLastTextForecastsUpdateTime(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getLong(PREF_TEXTFORECAST_LAST_UPDATE_TIME, PREF_TEXTFORECAST_LAST_UPDATE_TIME_DEFAULT);
    }

    public static boolean isTextForecastFilterEnabled(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_TEXTFORECAST_FILTER, PREF_TEXTFORECAST_FILTER_DEFAULT);
    }

    public static void setTextForecastFilterEnabled(Context context, boolean b){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_TEXTFORECAST_FILTER, b);
        pref_editor.apply();
    }

    public static boolean updateWarnings(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedPreferences.getBoolean(PREF_WARNINGS_DISABLE, PREF_WARNINGS_DISABLE_DEFAULT)) {
            return false;
        }
        else return sharedPreferences.getBoolean(PREF_UPDATE_WARNINGS, PREF_UPDATE_WARNINGS_DEFAULT);
    }

    public static boolean updateTextForecasts(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_UPDATE_TEXTFORECASTS, PREF_UPDATE_TEXTFORECASTS_DEFAULT);
    }

    public static void setPrefRadarLastdatapoll(Context context, long l){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putLong(PREF_RADAR_LASTDATAPOLL,l);
        pref_editor.apply();
    }

    public static long getPrefRadarLastdatapoll(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        long l = sharedPreferences.getLong(PREF_RADAR_LASTDATAPOLL,PREF_RADAR_LASTDATAPOLL_DEFAULT);
        return l;
    }

    public static boolean isRadarDataOutdated(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        long l = sharedPreferences.getLong(PREF_RADAR_LASTDATAPOLL,PREF_RADAR_LASTDATAPOLL_DEFAULT);
        return Calendar.getInstance().getTimeInMillis() > l + RadarMN.RADAR_DATAINTERVAL;
    }

    public static boolean showRadarByDefault(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_RADAR_SHOW,PREF_RADAR_SHOW_DEFAULT);
    }

    public static boolean showAdminMapByDefault(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_ADMINMAP_SHOW,PREF_ADMINMAP_SHOW_DEFAULT);
    }

    public static boolean getDisplayMunicipalities(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_MAP_DISPLAY_MUNICIPALITIES,PREF_MAP_DISPLAY_MUNICIPALITIES_DEFAULT);
    }

    public static boolean getDisplayCounties(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_MAP_DISPLAY_COUNTIES,PREF_MAP_DISPLAY_COUNTIES_DEFAULT);
    }

    public static boolean getDisplayStates(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_MAP_DISPLAY_STATES,PREF_MAP_DISPLAY_STATES_DEFAULT);
    }

    public static boolean getDisplaySeaAreas(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_MAP_DISPLAY_SEA_AREAS,PREF_MAP_DISPLAY_SEA_AREAS_DEFAULT);
    }

    public static boolean getDisplayCoastAreas(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_MAP_DISPLAY_COAST_AREAS,PREF_MAP_DISPLAY_COAST_AREAS_DEFAULT);
    }

    public static int[] getAreaTypeArray(Context context){
        ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
        if (getDisplayMunicipalities(context)){
            resultArrayList.add(Areas.Area.Type.GEMEINDE);
        }
        if (getDisplayCounties(context)){
            resultArrayList.add(Areas.Area.Type.KREIS);
        }
        if (getDisplayStates(context)){
            resultArrayList.add(Areas.Area.Type.BUNDESLAND);
        }
        if (getDisplaySeaAreas(context)){
            resultArrayList.add(Areas.Area.Type.SEE);
        }
        if (getDisplayCoastAreas(context)){
            resultArrayList.add(Areas.Area.Type.KUESTE);
        }
        Object[] o = resultArrayList.toArray();
        int[] result = new int[o.length];
        for (int i=0; i<o.length; i++){
            result[i] = (int) o [i];
        }
        return result;
    }

    public static boolean forceNoMenuIcons(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean b = sharedPreferences.getBoolean(PREF_FORCE_NO_MENU_ICONS,PREF_FORCE_NO_MENU_ICONS_DEFAULT);
        return b;
    }

    public static void setForceNoMenuIconsFlag(Context context, boolean b){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_FORCE_NO_MENU_ICONS,b);
        pref_editor.apply();
    }

    public static int getWindDisplayType(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String s = sharedPreferences.getString(PREF_DISPLAY_WIND_TYPE,PREF_DISPLAY_WIND_TYPE_DEFAULT);
        return getWindDisplayType(s);
    }

    public static boolean displayWindInRadar(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_DISPLAY_WIND_IN_RADAR,PREF_DISPLAY_WIND_IN_RADAR_DEFAULT);
    }

    public static boolean isAreaDatabaseReady(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_AREA_DATABASE_READY,PREF_AREA_DATABASE_READY_DEFAULT);
    }

    public static void setAreaDatabaseReady(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_AREA_DATABASE_READY,true);
        pref_editor.apply();
    }

    public static int getAreaDatabaseVersion(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(PREF_AREA_DATABASE_VERSION,PREF_AREA_DATABASE_VERSION_DEFAULT);
    }

    public static void setAreaDatabaseVersion(Context context, int version){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putInt(PREF_AREA_DATABASE_VERSION,version);
        pref_editor.apply();
    }

    public class ViewModel{
        final static String SIMPLE = "SIMPLE";
        final static String EXTENDED = "EXTENDED";
    }

    public static String getViewModel(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(PREF_VIEWMODEL,PREF_VIEWMODEL_DEFAULT);
    }

    public static void setViewModel(Context context, String model){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(PREF_VIEWMODEL,model);
        pref_editor.apply();
    }

    public static boolean preferAlternativeIcons(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_ALTERNATIVE_ICONS,PREF_ALTERNATIVE_ICONS_DEFAULT);
    }

    public static void setPreferAlternativeIcons(Context context, boolean b){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_ALTERNATIVE_ICONS,b);
        pref_editor.apply();
    }

    public static boolean getDisplaySunrise(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_DISPLAY_SUNRISE,PREF_DISPLAY_SUNRISE_DEFAULT);
    }

    public static void setDisplaySunrise(Context context, boolean b){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_DISPLAY_SUNRISE,b);
        pref_editor.apply();
    }

    public static int getWarningsUpdateIntervalMenuPosition(Context context){
        int getWarningsUpdateIntervalInMillis = (int) (getWarningsUpdateIntervalInMillis(context)/1000/60); // in minutes
        int result = 1;
        switch (getWarningsUpdateIntervalInMillis){
            case 15: result=0; break;
            case 30: result=1; break;
            case 60: result=2; break;
            case 120: result=3; break;
            case 180: result=4; break;
            case 360: result=5; break;
            default: result=1;
        }
        return result;
    }

    public static void setWarningsUpdateInterval(Context context, String s){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(PREF_WARNINGS_CACHETIME,s);
        pref_editor.apply();
    }

    public class Theme{
        final static String FOLLOW_DEVICE = "FOLLOW_DEVICE";
        final static String DARK = "DARK";
        final static String LIGHT = "LIGHT";
        final static String SOLARIZED_DARK = "SOLARIZED_DARK";
        final static String SOLARIZED = "SOLARIZED";
    }

    public static String getThemePreference(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(PREF_THEME,PREF_THEME_DEFAULT);
    }

    public static void setThemePreference(Context context, String theme){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putString(PREF_THEME,theme);
        pref_editor.apply();
    }

    public static boolean useMeteredNetworks(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_USE_METERED_NETWORKS,PREF_USE_METERED_NETWORKS_DEFAULT);
    }

    public static int getUniqueNotificationIdentifier(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i = sharedPreferences.getInt(PREF_NOTIFICATION_IDENTIFIER, PREF_NOTIFICATION_IDENTIFIER_DEFAULT);
        int b = i + 1;
        // prevent uncontrolled int rollover & respect reserved notification ID area
        if (b>NotificationIDRange.MAX){
            b = NotificationIDRange.MIN;
        }
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putInt(PREF_NOTIFICATION_IDENTIFIER,b);
        pref_editor.apply();
        return i;
    }

    public static void fixUniqueNotificationIdentifier(Context context){
        int identifier = getUniqueNotificationIdentifier(context);
        if (identifier>NotificationIDRange.MAX){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor pref_editor = sharedPreferences.edit();
            pref_editor.putInt(PREF_DISPLAY_OVERVIEWCHART,NotificationIDRange.MIN);
            pref_editor.apply();
        }
    }

    public static boolean cropPrecipitationChart(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_DISPLAY_CROP_PRECIPITATIONCHART,PREF_DISPLAY_CROP_PRECIPITATIONCHART_DEFAULT);
    }

    public static boolean displayOverviewChart(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_DISPLAY_OVERVIEWCHART,PREF_DISPLAY_OVERVIEWCHART_DEFAULT);
    }

    public static void setDisplayOverviewChart(Context context, boolean value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_DISPLAY_OVERVIEWCHART,value);
        pref_editor.apply();
    }

    public static int getDisplayOverviewChartDays(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(PREF_DISPLAY_OVERVIEWCHART_DAYS,PREF_DISPLAY_OVERVIEWCHART_DAYS_DEFAULT);
    }

    public static void setDisplayOverviewChartDays(Context context, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putInt(PREF_DISPLAY_OVERVIEWCHART_DAYS,value);
        pref_editor.apply();
    }

    public static void setAskedLocationFlag(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putBoolean(PREF_ASKEDFORLOCATIONPERMISSION,true);
        pref_editor.apply();
    }

    public static boolean askedForLocationPermission(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_ASKEDFORLOCATIONPERMISSION,PREF_ASKEDFORLOCATIONPERMISSION_DEFAULT);
    }

    public final class DeviceRotation {
        final static String DEVICE = "0";
        final static String PORTRAIT = "1";
        final static String LANDSCAPE = "2";
    }

    public static String getRotationmode(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String rotationMode = sharedPreferences.getString(PREF_ROTATIONMODE,PREF_ROTATIONMODE_DEFAULT);
        return rotationMode;
    }

    public static String getDeviceRotationString(Context context){
        String rotationMode = getRotationmode(context);
        String[] s = context.getResources().getStringArray(R.array.display_rotation_text);
        if (rotationMode.equals(DeviceRotation.LANDSCAPE)){
            return s[2];
        }
        if (rotationMode.equals(DeviceRotation.PORTRAIT)){
            return s[1];
        }
        return s[0];
    }

    public static void setRotationMode(Activity activity){
        String rotationMode = getRotationmode(activity.getApplicationContext());
        if (rotationMode.equals(DeviceRotation.LANDSCAPE)){
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (rotationMode.equals(DeviceRotation.PORTRAIT)){
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            //activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }
    }

    public static boolean loggingEnabled(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_LOGGING,PREF_LOGGING_DEFAULT);
    }

    public static boolean loggingToLogcatEnabled(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_LOG_TO_LOGCAT,PREF_LOG_TO_LOGCAT_DEFAULT);
    }

    public static boolean useOverviewChartMinMax(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE,PREF_DISPLAY_OVERVIEWCHART_MINMAXUSE_DEFAULT);
    }

    public static int getOverviewChartMin(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return Integer.parseInt(NumberPickerPreference.minValues[sharedPreferences.getInt(PREF_DISPLAY_OVERVIEWCHART_MIN,PREF_DISPLAY_OVERVIEWCHART_MIN_DEFAULT)]);
    }

    public static int getOverviewChartMax(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return Integer.parseInt(NumberPickerPreference.maxValues[sharedPreferences.getInt(PREF_DISPLAY_OVERVIEWCHART_MAX,PREF_DISPLAY_OVERVIEWCHART_MAX_DEFAULT)]);
    }

    public static String getNotificationChannelID(long identifier){
        return DataUpdateService.WARNING_NC_ID_SKELETON + String.valueOf(identifier);
    }

    public static String getNotificationChannelID(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        long current = sharedPreferences.getLong(PREF_NC_CHANNEL_DETAIL, 0);
        String nc = getNotificationChannelID(current);
        return nc;
    }

    public static String setNewNotificationChannelID(Context context){
        long time = Calendar.getInstance().getTimeInMillis();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putLong(PREF_NC_CHANNEL_DETAIL,time);
        pref_editor.apply();
        return getNotificationChannelID(time);
    }

    /**
     * Removes the old notification channel and creates a new one on API >= 26. On older versions, it simply
     * returns the channel.
     * @param context
     * @return
     */

    public static String newNotificationChannel(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String oldChannelID = getNotificationChannelID(context);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.deleteNotificationChannel(oldChannelID);
            String newChannelID = setNewNotificationChannelID(context);
            return newChannelID;
        }
        return getNotificationChannelID(context);
    }

    public static boolean LEDEnabled(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_WARNINGS_NOTIFY_LED,PREF_WARNINGS_NOTIFY_LED_DEFAULT);
    }

    public static int getLEDColorItem(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(PREF_LED_COLOR,PREF_LED_COLOR_DEFAULT);
    }

    public static void setLEDColorItem(Context context, int newColor){
        int oldColor = getLEDColorItem(context);
        if (newColor!=oldColor){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor pref_editor = sharedPreferences.edit();
            pref_editor.putInt(PREF_LED_COLOR,newColor);
            pref_editor.apply();
            newNotificationChannel(context);
        }
    }

    public static int getLEDColor(Context context){
        return NotificationLEDcolors[getLEDColorItem(context)];
    }

    public static int getHintCounter1(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(PREF_HINTCOUNTER1,PREF_HINTCOUNTER1_DEFAULT);
    }

    public static void setHintCounter1(Context context, int value){
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    SharedPreferences.Editor pref_editor = sharedPreferences.edit();
            pref_editor.putInt(PREF_HINTCOUNTER1,value);
            pref_editor.apply();
    }

    public static int getHintCounter2(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(PREF_HINTCOUNTER2,PREF_HINTCOUNTER2_DEFAULT);
    }

    public static void setHintCounter2(Context context, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putInt(PREF_HINTCOUNTER2,value);
        pref_editor.apply();
    }

    public static long getMapLastUpdateTime(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getLong(PREF_MAPLASTUPDATETIME,PREF_UVIMAPLASTUPDATETIME_DEFAULT);
    }

    public static boolean isLayerUpdateAllowed(Context context){
        long lastUpdateTime = getMapLastUpdateTime(context);
        // the DWD kindly asks not to update layers more often than every 5 minutes. We comply with that.
        // Source: https://www.dwd.de/DE/wetter/warnungen_aktuell/objekt_einbindung/einbindung_karten_geodienste.pdf?__blob=publicationFile&v=14
        return (Calendar.getInstance().getTimeInMillis() + 1000*60*5 > lastUpdateTime);
    }

    public static void setMapLastUpdateTime(Context context, long value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putLong(PREF_MAPLASTUPDATETIME,value);
        pref_editor.apply();
    }

    public static long getLayerTime(Context context, int position){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String key = "PREF_LAYERTIME_"+position;
        return sharedPreferences.getLong(key,PREF_LAYERTIME_DEFAULT);
    }

    public static void setLayerTime(Context context, int position, long time){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        String key = "PREF_LAYERTIME_"+position;
        pref_editor.putLong(key,time);
        pref_editor.apply();
    }

    public static int getLastDisplayedLayer(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(PREF_LASTMAPDISPLAYED,PREF_LASTMAPDISPLAYED_DEFAULT);
    }

    public static void setLastDisplayedLayer(Context context, int layer){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pref_editor = sharedPreferences.edit();
        pref_editor.putInt(PREF_LASTMAPDISPLAYED,layer);
        pref_editor.apply();
    }
}
