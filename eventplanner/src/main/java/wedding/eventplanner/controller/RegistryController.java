package wedding.eventplanner.controller;

import wedding.eventplanner.RegistryItem;
import wedding.eventplanner.service.RegistryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/registry")
public class RegistryController {

    private final RegistryService registryService;

    public RegistryController(RegistryService registryService) {
        this.registryService = registryService;
    }

    @PostMapping("/create")
    public String createRegistryItem(@RequestBody RegistryItem registryItem)
            throws ExecutionException, InterruptedException {
        return registryService.createRegistryItem(registryItem);
    }

    @GetMapping("/{id}")
    public RegistryItem getRegistryItemById(@PathVariable String id) throws ExecutionException, InterruptedException {
        return registryService.getRegistryItemById(id);
    }

    @GetMapping
    public List<RegistryItem> getAllRegistryItems() throws ExecutionException, InterruptedException {
        return registryService.getAllRegistryItems();
    }

    @PutMapping("/{id}")
    public String updateRegistryItem(@PathVariable String id, @RequestBody RegistryItem registryItem)
            throws ExecutionException, InterruptedException {
        return registryService.updateRegistryItem(id, registryItem);
    }

    @DeleteMapping("/{id}")
    public String deleteRegistryItem(@PathVariable String id) throws ExecutionException, InterruptedException {
        return registryService.deleteRegistryItem(id);
    }
}
