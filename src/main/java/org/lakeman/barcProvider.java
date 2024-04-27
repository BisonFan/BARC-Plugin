package org.lakeman;

import org.ka2ddo.yaac.YAAC;
import org.ka2ddo.yaac.ax25.StationTracker;

public class barcProvider extends org.ka2ddo.yaac.pluginapi.Provider {

    protected barcProvider(String name, String version, String author, String info) {
        super("BARC Plug-in", "V0.1", "Brian Lakeman, N0KBL", "<html>BARC plug-in for YAAC</html>");
        // TODO Auto-generated constructor stub
    }

    /**
     * Execute this function before calling any of the other functions of the
     * Provider. This allows any Provider-specific initialization to run before
     * menus
     * and drivers are loaded, and also permits the Provider to block usage of the
     * plugin (for example, if the plugin provides services only available on
     * Microsoft Windows, but YAAC is being executed on Mac OS X).
     *
     * @param providerApiVersion the int version of the Provider API supported by
     *                           the build of YAAC trying to load this plugin
     * @return boolean false if this plugin cannot be loaded for some reason (such
     *         as
     *         missing pre-requisite software on the executing platform, or
     *         requiring
     *         a version of YAAC newer than the executing one)
     */
    @Override
    public boolean runInitializersBefore(int providerApiVersion) {
        return providerApiVersion >= 26;
    }

    /**
     * Get the explanation why the call to {@link #runInitializersBefore(int)}
     * returned failure status.
     * If the localized error message has parameters that should be substituted
     * into it, overrides of this method should do the lookup and MessageFormat
     * substitution itself rather than
     * expecting YAAC to do it, i.e.,
     * <code>
     * return MessageFormat.format(YAAC.getMsg(PLUGIN_NEEDS_NEWER_YAAC_PROTOCOL), YAAC.getCoreProviderVersion(), 15);
     * </code>
     * <p>
     * The superclass method {@link #buildNewerYaacNeededMsg(int)} is available to
     * produce such a
     * message if needed.
     * </p>
     *
     * @return String of failure reason (or resource tag name if begun with a
     *         package-qualified Resource name), or null if the plugin successfully
     *         initialized
     * @see #runInitializersBefore(int)
     */
    @Override
    public String getInitFailureReason() {
        return buildNewerYaacNeededMsg(26);
    }

    /**
     * Execute this function after calling all of the other functions of the
     * Provider. This allows any Provider-specific initialization to run after menus
     * and drivers are loaded.
     */
    @Override
    public void runInitializersAfter() {
        if (!Boolean.parseBoolean((String) YAAC.getProps().get(YAAC.OPT_GUI))) {
            // add announcement listener for changes in station positions
            //StationTracker.getInstance().addTrackerListener(new SampleVectorCalculator());
        }
    }

    /**
     * Specify attributions, credits/acknowledgements, and license references to be
     * displayed in the
     * About dialog box. This method is called when the Help-&gt;About menu choice
     * is
     * selected.
     *
     * @return array of localized Strings, each containing one attribution or
     *         acknowledgement
     */
    @Override
    public String[] getAboutAttributions() {
        return new String[] {
                "sample plugin \u00A9 2011-2022 Andrew Pavlin, KA2DDO"
        };
    }
}
