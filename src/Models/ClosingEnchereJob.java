package Models;

import Models.Enchere;
import Services.EnchereService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;
import java.util.stream.Collectors;

public class ClosingEnchereJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        EnchereService enchereService = new EnchereService();
        List<Enchere> openEncheres = enchereService
                .getEncheres()
                .stream()
                .filter(enchere -> enchere.getGagnant() != null)
                .collect(Collectors.toList());
        for (Enchere enchere : openEncheres) {
            enchereService.closeEnchere(enchere);
        }
    }
}
