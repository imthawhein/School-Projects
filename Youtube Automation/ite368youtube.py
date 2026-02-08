from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service
import time

def setup_driver():
    service = Service("/usr/local/bin/chromedriver")  
    options = webdriver.ChromeOptions()
    options.add_argument("--start-maximized")
    return webdriver.Chrome(service=service, options=options)

def youtube_automation():
    driver = setup_driver()
    driver.get("https://www.youtube.com")
    time.sleep(3)  # Wait for homepage

    # Accept cookies if prompted (for some regions)
    try:
        accept_btn = driver.find_element(By.XPATH, "//ytd-button-renderer//a[contains(text(),'Accept all')]")
        accept_btn.click()
        time.sleep(2)
    except:
        pass  # No popup, continue

    # Search for "no more lies"
    search_box = driver.find_element(By.NAME, "search_query")
    search_box.send_keys("no more lies james charles")
    search_box.send_keys(Keys.RETURN)
    time.sleep(4)

    # Click first video
    first_video = driver.find_element(By.XPATH, "(//ytd-video-renderer//a[@id='thumbnail'])[1]")
    first_video.click()
    print("🎬 Playing first video...")

    # Play for 10 seconds
    time.sleep(10)

    # Pause video
    try:
        pause_button = driver.find_element(By.CLASS_NAME, "ytp-play-button")
        pause_button.click()
        print("⏸ Video paused after 10 seconds.")
    except:
        print("⚠️ Pause button not found.")

    # Wait 5 seconds before scrolling
    time.sleep(5)

    # Scroll to comments
    try:
        driver.execute_script("window.scrollTo(0, document.documentElement.scrollHeight * 0.5);")
        time.sleep(5)
        driver.execute_script("window.scrollTo(0, document.documentElement.scrollHeight * 0.95);")
        print("💬 Scrolled to comments.")
    except:
        print("⚠️ Failed to scroll to comments.")

    # Scroll back to top
    time.sleep(2)
    try:
        driver.execute_script("window.scrollTo(0, 0);")
        time.sleep(2)
        print("🔝 Scrolled back to top.")
    except:
        print("⚠️ Failed to scroll back to top.")

    # Play the video again
    try:
        play_button = driver.find_element(By.CLASS_NAME, "ytp-play-button")
        play_button.click()
        print("▶️ Video resumed.")
    except:
        print("⚠️ Play button not found.")

    time.sleep(10)
    driver.quit()
    print("✅ Script finished and browser closed.")

youtube_automation()
