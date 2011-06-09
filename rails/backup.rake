# lib/tasks/backup.rake

# Create a backup of a Rails application deployed to Heroku
# Technique taken from Ben Scheirman - http://flux88.com/2010/02/scripting-heroku-backups/
# Place file in lib/tasks/backup.rake (replace your_app_name with your application's Heroku name)
# Invoke using rake your_app_name:backup
# Dependencies: the heroku gem, the pgbackups heroku addon
namespace :your_app_name do
	desc 'Captures a heroku backup. Ensure you have the heroku gem and pgbackups addon installed\n
				gem install heroku && heroku addons:add pgbackups'
	
	task :backup do
		# capture the backup bundle
		timestamp = `date -u '+%Y-%m-%d-%H-%M'`.chomp
		bundle_name = "your_app_name-#{timestamp}"
		puts "Capturing bundle #{bundle_name}..."
		`heroku pgbackups:capture --expire`

		# download & destroy the bundle we just captured
		puts "Downloading bundle #{bundle_name}.dump"
		backup_url = `heroku pgbackups:url`
		`curl -o '#{bundle_name}'.dump '#{backup_url}'`

		# move the backup
		puts "Moving bundle to backups/#{bundle_name}.dump"
		`mkdir -p backups/`
		`mv '#{bundle_name}'.dump backups/#{bundle_name}.dump`
	end
end
