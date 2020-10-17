package top.dsbbs2.smj;

import java.io.File;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import top.dsbbs2.smj.plugin.PluginList;
import top.dsbbs2.smj.plugin.PluginLoader;

public class Main extends JavaPlugin {
	public static final Main INSTANCE = new Main();
    private Main() {
        super(new JvmPluginDescriptionBuilder("top.dsbbs2.smj.SimpleMiraiJs", "1.0.0").build());
    }
    protected static final PluginList plugins = new PluginList();
    public static PluginList getPlugins()
    {
      return Main.plugins;
    }
	@Override
	public void onEnable() {
		final File pls = new File("jsplugins");
	      if (!pls.isDirectory()) {
	        pls.mkdirs();
	      }
	      for (final File i : pls.listFiles()) {
	        if (i.isDirectory()) {
	          this.getLogger().info("Loading js plugin \""+i.getName()+"\"");
	          try {
	          new PluginLoader(i.getName());
	          }catch (Throwable e) {
				this.getLogger().error("Exception occurred while loading js plugin \""+i.getName()+"\": " ,e);
			}
	        }
	      }
	}
    
}
