package com.financial.sync.controller;

import com.financial.sync.entity.User;
import com.financial.sync.repository.XeroInvoiceRepository;
import com.financial.sync.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000" })
public class DashboardController {

	private final AuthService authService;
	private final XeroInvoiceRepository invoiceRepository;

	@GetMapping("/stats")
	public ResponseEntity<Map<String, Object>> getDashboardStats() {
		User currentUser = authService.getCurrentUser();

		Map<String, Object> stats = new HashMap<>();
		stats.put("totalInvoices", invoiceRepository.countByUser(currentUser));
		stats.put("username", currentUser.getUsername());
		stats.put("xeroConnected", currentUser.getXeroAccessToken() != null);

		return ResponseEntity.ok(stats);
	}
}