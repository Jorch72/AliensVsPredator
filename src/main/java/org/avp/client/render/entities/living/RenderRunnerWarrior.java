package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelRunnerWarrior;
import org.avp.entities.living.EntityRunnerWarrior;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRunnerWarrior extends RenderXenomorph<EntityRunnerWarrior, ModelRunnerWarrior>
{
    public RenderRunnerWarrior(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().RUNNER_WARRIOR, 1F);
    }
}
