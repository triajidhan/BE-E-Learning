package com.lawencon.elearning.service;

import com.lawencon.elearning.pojo.SendEmailPojo;

public interface JavaMailService {

	void sendEmail(SendEmailPojo createdAccountPojo);
}
