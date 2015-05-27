package name.schnee.gpw;

/* GPW - Generate pronounceable passwords
   This program uses statistics on the frequency of three-letter sequences
   in English to generate passwords.  The statistics are
   generated from your dictionary by the program loadtris.

   See www.multicians.org/thvv/gpw.html for history and info.
   Tom Van Vleck

   THVV 06/01/94 Coded
   THVV 04/14/96 converted to Java
   THVV 07/30/97 fixed for Netscape 4.0
   */

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.List;

public class Gpw extends Applet
{
    private GpwWindow GpwWindow = null;
    private Button gpw_button = null;

    public Gpw()
    { // constructor
        this.setLayout(new BorderLayout());
        this.setFont(new Font("Helvetica", Font.BOLD, 14));
        this.add("Center", gpw_button = new Button("Generate Passwords"));
    } // constructor

    // Invoked when "Generate" button is pushed
    public boolean action(Event evt, Object arg)
    {
        if (evt.target == gpw_button)
        {
            // create a new password window every time.
            GpwWindow = new GpwWindow(this.getParameter("npw"),
                                      this.getParameter("pwlength"));
            GpwWindow.show(); // show the password box.
        }
        return true;
    } // action()

    // Boiler plate for HotJava
    public String getAppletInfo()
    {
        return "Generate Passwords 96-04-14 THVV";
    } // getAppletInfo()

    public String[][] getParameterInfo()
    {
        String[][] info = {
            {"pwlength", "int", "length of passwords"},
            {"npw", "int", "number of passwords"}
        };
        return info;
    } // getParameterInfo()

    // Main program for testing only.
    public static void main(String args[])
    {
        Frame f = new Frame("name.schnee.gpw.Gpw");
        Gpw gpw = new Gpw();
        gpw.init();
        gpw.start();
        f.add("Center", gpw);
        f.resize(600, 300);
        f.show();
    } // main()
} // name.schnee.gpw.Gpw

// ================================================================
// Box showing the generated passwords

class GpwWindow extends Frame
{
    protected Button ok_button = null;
    protected Panel pw_panel_north = null;
    int npw = 10;
    int pwl = 8;

    GpwWindow(String bvnpw, String bvpwl)
    { // constructor
        try
        {
            npw = Integer.parseInt(bvnpw, 10);
        }
        catch (NumberFormatException ew)
        {
            npw = 10;
        }
        try
        {
            pwl = Integer.parseInt(bvpwl, 10);
        }
        catch (NumberFormatException eh)
        {
            pwl = 8;
        }
        // set up a window with a text box and an OK button
        this.setFont(new Font("Courier", Font.PLAIN, 14));
        this.setLayout(new BorderLayout(5, 5));

        pw_panel_north = new Panel();
        pw_panel_north.setLayout(new GridLayout(0, 1));
        this.generate(pw_panel_north, npw, pwl);
        this.add("North", pw_panel_north);

        Panel pw_panel_south = new Panel();
        pw_panel_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        pw_panel_south.add(ok_button = new Button("OK"));
        ok_button.setFont(new Font("Helvetica", Font.BOLD, 14));
        this.add("South", pw_panel_south);
        this.pack();
    } // constructor

    public boolean action(Event e, Object arg)
    {
        if (e.target == ok_button)
        {
            this.hide();
            this.dispose();
            return true;
        }
        return false;
    } // action()

    public boolean gotFocus(Event e, Object arg)
    {
        ok_button.requestFocus();
        return true;
    } // gotFocus()


    private void generate(Panel pan, int npw, int pwl)
    {
        List<String> passwords = PasswordGenerator.generate(npw, pwl, new byte[]{0});
        for (int i = 0; i < passwords.size(); i++)
        {
            String s = (String) passwords.get(i);
            pan.add(new Label(s)); // Password generated
        }

    } // generate()

} // GpwWindow

