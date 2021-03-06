package me.theditor.xelt.commands.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.theditor.xelt.commands.api.BaseCommand;
import me.theditor.xelt.commands.api.CommandCategory;
import me.theditor.xelt.utils.MessageUtils;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class RollCommand extends BaseCommand{

	private CommandCategory category;

	public RollCommand(CommandCategory category) {
		this.category = category;
	}

	@Override
	public void run(GuildMessageReceivedEvent e, List<String> args) {
		Random rand = new Random();
		
		List<String> msgs = new ArrayList<>();
		msgs.add("\uD83C\uDFB2 You rolled the dice and got " + (rand.nextInt(100) + 1));
		e.getChannel().sendMessage(MessageUtils.noFieldMessageEmbed("Dice Rolled", msgs, e.getChannel()).build()).queue();
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getName() {
		return "Roll";
	}

	@Override
	public String getDescription() {
		return "Returns a random number from 1 to 100!";
	}

	@Override
	public String getUsage(Guild guild) {
		return getName().toLowerCase();
	}

	@Override
	public CommandCategory getParentCategory() {
		return category;
	}
	
}
