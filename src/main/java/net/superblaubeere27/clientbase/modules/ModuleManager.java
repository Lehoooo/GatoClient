/*
 * Copyright (c) 2018 superblaubeere27
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.superblaubeere27.clientbase.modules;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;
import net.superblaubeere27.clientbase.ClientBase;
import net.superblaubeere27.clientbase.events.KeyEvent;
import net.superblaubeere27.clientbase.modules.modules.combat.Criticals;
import net.superblaubeere27.clientbase.modules.modules.combat.Killaura;
import net.superblaubeere27.clientbase.modules.modules.combat.KillauraTest;
import net.superblaubeere27.clientbase.modules.modules.combat.Velocity;
import net.superblaubeere27.clientbase.modules.modules.fun.ClickLongJump;
import net.superblaubeere27.clientbase.modules.modules.fun.DemoModeModule;
import net.superblaubeere27.clientbase.modules.modules.fun.FastPlace;
import net.superblaubeere27.clientbase.modules.modules.movement.AntiVoid;
import net.superblaubeere27.clientbase.modules.modules.movement.FakePlayer;
import net.superblaubeere27.clientbase.modules.modules.movement.EdgeSneak;
import net.superblaubeere27.clientbase.modules.modules.movement.Fly;
import net.superblaubeere27.clientbase.modules.modules.movement.Glide;
import net.superblaubeere27.clientbase.modules.modules.movement.Step;
import net.superblaubeere27.clientbase.modules.modules.movement.NoFall;
import net.superblaubeere27.clientbase.modules.modules.movement.SetbackDetector;
import net.superblaubeere27.clientbase.modules.modules.movement.Speed;
import net.superblaubeere27.clientbase.modules.modules.movement.Sprint;
import net.superblaubeere27.clientbase.modules.modules.render.ClickGUIModule;
import net.superblaubeere27.clientbase.modules.modules.render.ESP;
import net.superblaubeere27.clientbase.modules.modules.render.Fullbright;
import net.superblaubeere27.clientbase.modules.modules.render.HUD;
import net.superblaubeere27.clientbase.modules.modules.render.SpeedGraph;
import net.superblaubeere27.clientbase.modules.modules.render.TabGuiModule;
import net.superblaubeere27.clientbase.modules.modules.utils.FastEat;
import net.superblaubeere27.clientbase.scripting.ScriptModule;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    @NotNull
    private List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        EventManager.register(this);
    }


    public void addModules() {
        addModule(new DemoModeModule());
        addModule(new SetbackDetector());
        addModule(new Speed());
        addModule(new Fly());
        addModule(new Sprint());
        addModule(new Fullbright());
        addModule(new FastPlace());
        addModule(new Killaura());
        addModule(new Criticals());
        addModule(new NoFall());
        addModule(new Velocity());
        addModule(new ESP());
        addModule(new FastEat());
        addModule(new ClickLongJump());
        addModule(new KillauraTest());
        addModule(new EdgeSneak());
        addModule(new SpeedGraph());
        addModule(new TabGuiModule());
        addModule(new AntiVoid());
        addModule(new FakePlayer());
        addModule(new Step());
        addModule(new Glide());
        // Register your modules here

        addModule(new ClickGUIModule());
        addModule(new HUD());
    }

    private void addModule(@NotNull Module module) {
        modules.add(module);
        EventManager.register(module);
        ClientBase.INSTANCE.valueManager.registerObject(module.getName(), module);
    }

    @NotNull
    public List<Module> getModules() {
        return modules;
    }

    @NotNull
    public <T extends Module> T getModule(Class<T> clazz) {
        return (T) modules.stream().filter(mod -> mod.getClass() == clazz).findFirst().orElse(null);
    }

    public Module getModule(@NotNull String name, boolean caseSensitive) {
        return modules.stream().filter(mod -> !caseSensitive && name.equalsIgnoreCase(mod.getName()) || name.equals(mod.getName())).findFirst().orElse(null);
    }

    @EventTarget
    private void onKey(@NotNull KeyEvent event) {
        for (Module module : modules) if (module.getKeybind() == event.getKey()) module.setState(!module.getState());
    }

    public void addScriptModule(ScriptModule module) {
        addModule(module);
    }
}
