package com.stackroute.downstreamservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.downstreamservice.model.AcademicQualification;
import com.stackroute.downstreamservice.model.Certificates;
import com.stackroute.downstreamservice.model.Experience;
import com.stackroute.downstreamservice.model.Location;
import com.stackroute.downstreamservice.model.PersonalInfo;
import com.stackroute.downstreamservice.model.Projects;
import com.stackroute.downstreamservice.model.Skills;
import com.stackroute.downstreamservice.model.User;
import com.stackroute.downstreamservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepo;
	private Optional<User> opt;
	private User user;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public void saveCertificate(Certificates certificates) {
		opt = userRepo.findById(certificates.getProfileId());
		user = opt.get();
		List<Certificates> list;
		if (user.getCertificates() == null)
			list = new ArrayList<>();
		else
			list = user.getCertificates();

		list.add(certificates);
		user.setCertificates(list);
		user.setUsername(certificates.getProfileId());
		userRepo.save(user);

		logger.info(certificates.toString() + " training");
	}

	@Override
	public void saveSkill(Skills skills) {
		opt = userRepo.findById(skills.getProfileId());
		user = opt.get();
		List<Skills> list;
		if (user.getSkills() == null)
			list = new ArrayList<>();
		else
			list = user.getSkills();

		list.add(skills);
		user.setSkills(list);
		userRepo.save(user);

		logger.info(skills.toString() + " skills");
	}

	@Override
	public void saveProject(Projects project) {
		List<Projects> list;
		opt = userRepo.findById(project.getProfileId());
		user = opt.get();

		if (user.getProject() == null)
			list = new ArrayList<>();
		else
			list = user.getProject();

		list.add(project);
		user.setProject(list);
		userRepo.save(user);
		logger.info(project.toString() + " project");
	}

	@Override
	public void savePersonalInfo(PersonalInfo personalInfo) {
		user.setPersonalInfo(personalInfo);
		user.setUsername(personalInfo.getProfileId());
		userRepo.save(user);

		logger.info(personalInfo.toString() + " personal info");
	}

	@Override
	public void saveLocation(Location location) {
		opt = userRepo.findById(location.getProfileId());
		user = opt.get();
		List<Location> list;
		if (user.getLocation() == null)
			list = new ArrayList<>();
		else
			list = user.getLocation();

		list.add(location);
		user.setLocation(list);
		userRepo.save(user);

		logger.info(location.toString() + " location");
	}

	@Override
	public void saveAcademies(AcademicQualification academies) {
		opt = userRepo.findById(academies.getProfileId());
		user = opt.get();
		List<AcademicQualification> list;
		if (user.getExperience() == null)
			list = new ArrayList<>();
		else
			list = user.getAcademics();
		list.add(academies);
		user.setAcademics(list);
		logger.info(academies.toString() + " academies");
		userRepo.save(user);
	}

	@Override
	public void saveExperience(Experience experience) {
		opt = userRepo.findById(experience.getProfileId());
		user = opt.get();
		List<Experience> list;
		if (user.getExperience() == null)
			list = new ArrayList<>();
		else
			list = user.getExperience();
		list.add(experience);
		user.setExperience(list);
		user.setUsername(experience.getProfileId());
		userRepo.save(user);
	}
	
	@Override
	public void deleteEntry(String username) {
		userRepo.deleteById(username);
	}

	@Override
	public User updateEntry(User user, String username) {
			user.setUsername(username);
			return userRepo.save(user);
	}
}
